package com.sensors.backEnd;

import java.util.TimerTask;

import com.sensors.backEnd.database.JDBCDataDAO;
import com.sensors.backEnd.readData.LuminosityMoisiture;
import com.sensors.backEnd.readData.TemperatureHumidity;

public class ReadData extends TimerTask{
	LuminosityMoisiture luminosityMoisiture;
	TemperatureHumidity temperatureHumidity;
	JDBCDataDAO dataJDBC;
	
	public ReadData(LuminosityMoisiture luminosityMoisiture,
			TemperatureHumidity temperatureHumidity, JDBCDataDAO dataJDBC) {
		super();
		this.luminosityMoisiture = luminosityMoisiture;
		this.temperatureHumidity = temperatureHumidity;
		this.dataJDBC = dataJDBC;
	}

	@Override
	public void run() {
		temperatureHumidity.read();
		luminosityMoisiture.read();
		Data data = new Data(temperatureHumidity.getTemperature(),
				temperatureHumidity.getHumidity(),
				luminosityMoisiture.getMoisiture(),
				luminosityMoisiture.getLuminosity());
		System.out.println(data);
		dataJDBC.insert(data);;
	}

}
