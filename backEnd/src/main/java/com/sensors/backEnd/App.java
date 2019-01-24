package com.sensors.backEnd;

import com.sensors.backEnd.readData.*;

public class App {
	public static void main(String[] args) {
		LuminosityMoisiture luminosityMoisiture = new LuminosityMoisiture();
		TemperatureHumidity temperatureHumidity = new TemperatureHumidity();
		temperatureHumidity.read();
		luminosityMoisiture.read();
		Data data = new Data(temperatureHumidity.getTemperature(),
				temperatureHumidity.getHumidity(),
				luminosityMoisiture.getMoisiture(),
				luminosityMoisiture.getLuminosity());
		System.out.println(data);
	}
}
