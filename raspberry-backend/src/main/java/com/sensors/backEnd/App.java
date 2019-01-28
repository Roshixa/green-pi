package com.sensors.backEnd;

import java.util.Timer;

import com.sensors.backEnd.database.JDBCDataDAO;
import com.sensors.backEnd.readData.*;

public class App {
	public static void main(String[] args) {
		Timer timer = new Timer();
		JDBCDataDAO dataJDBC = new JDBCDataDAO();
		LuminosityMoisiture luminosityMoisiture = new LuminosityMoisiture();
		TemperatureHumidity temperatureHumidity = new TemperatureHumidity();
		ReadData readData = new ReadData(luminosityMoisiture, temperatureHumidity, dataJDBC);
		dataJDBC.createNewTable();
		timer.scheduleAtFixedRate(readData, 0, 10000);
	}
}
