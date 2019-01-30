package com.sensors.raspberry.service;

import com.pi4j.io.spi.SpiChannel;
import com.pi4j.io.spi.SpiDevice;
import com.pi4j.io.spi.SpiFactory;
import com.sensors.raspberry.beans.Data;
import com.sensors.raspberry.dao.DataDao;
import com.sensors.raspberry.dao.DataDaoImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TimerTask;

public class DataServiceImpl extends TimerTask implements DataService {
    private final static int MOISTURE_CHANNEL = 1;
    private final static int LUMINOSITY_CHANNEL = 0;
    private final static String SCRIPT_PATH = "src/main/java/com/sensors/raspberry/utils/ReadTemperatureHumidity.py";

    private final DataDao dataDao;
    private SpiDevice spiDevice;

    public DataServiceImpl() {
        this.dataDao = new DataDaoImpl();
        try {
            this.spiDevice = SpiFactory.getInstance(SpiChannel.CS0,
                    SpiDevice.DEFAULT_SPI_SPEED, SpiDevice.DEFAULT_SPI_MODE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            Process p = Runtime.getRuntime().exec("python " + SCRIPT_PATH);
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            Double luminosity, moisture, temperature, humidity;
            luminosity = readFromChannel(LUMINOSITY_CHANNEL);
            moisture = readFromChannel(MOISTURE_CHANNEL);
            temperature = Double.valueOf(in.readLine());
            humidity = Double.valueOf(in.readLine());
            add(temperature, humidity, moisture, luminosity);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean add(Double temperature, Double humidity, Double moisture, Double luminosity) {
        Data data = new Data(temperature, humidity, moisture, luminosity);
        return dataDao.save(data);
    }

    private synchronized Double readFromChannel(int channel) throws IOException {
        byte[] packet = new byte[3];
        packet[0] = 0x01;
        packet[1] = (byte) ((0x08 + channel) << 4);
        packet[2] = 0x00;
        byte[] result = this.spiDevice.write(packet);
        return Double.valueOf(((result[1] & 0x03) << 8) | (result[2] & 0xff));
    }
}
