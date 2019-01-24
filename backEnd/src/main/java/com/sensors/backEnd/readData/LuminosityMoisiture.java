package com.sensors.backEnd.readData;

import com.pi4j.io.spi.SpiChannel;
import com.pi4j.io.spi.SpiDevice;
import com.pi4j.io.spi.SpiFactory;
import java.io.IOException;

public class LuminosityMoisiture {
	private SpiDevice spi = null;
	private Double luminosity;
	private Double moisiture;
	private int luminosityChannel = 0;
	private int moisitureChannel = 1;

	public LuminosityMoisiture() {
		super();
	}

	public Double getLuminosity() {
		return luminosity;
	}

	public Double getMoisiture() {
		return moisiture;
	}

	public void read() {
		try {
			this.spi = SpiFactory.getInstance(SpiChannel.CS0,
					SpiDevice.DEFAULT_SPI_SPEED, SpiDevice.DEFAULT_SPI_MODE);
			this.luminosity = readLuminosity();
			this.moisiture = readMoisiture();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private Double readMoisiture() throws InterruptedException, IOException {
		return readFromChannel(moisitureChannel);
	}

	private Double readLuminosity() throws InterruptedException, IOException {
		return readFromChannel(luminosityChannel);
	}

	private synchronized Double readFromChannel(int channel) throws IOException {
		byte packet[] = new byte[3];
		packet[0] = 0x01;
		packet[1] = (byte) ((0x08 + channel) << 4);
		packet[2] = 0x00;
		byte[] result = spi.write(packet);
		return Double.valueOf(((result[1] & 0x03) << 8) | (result[2] & 0xff));
	}
}
