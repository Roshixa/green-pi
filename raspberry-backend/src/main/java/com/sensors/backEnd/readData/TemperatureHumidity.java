package com.sensors.backEnd.readData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TemperatureHumidity {
	private Double temperature;
	private Double humidity;
	private String scriptPath = "src/main/java/com/sensors/backEnd/readData/TemperatureHumidity.py";
	
	public TemperatureHumidity() {
		super();
	}

	public Double getTemperature() {
		return temperature;
	}

	public Double getHumidity() {
		return humidity;
	}

	public void read() {
		try {
		Process p = Runtime.getRuntime().exec("python " + scriptPath);
		BufferedReader in = new BufferedReader(new InputStreamReader(
				p.getInputStream()));
			temperature = Double.valueOf(in.readLine());
			humidity = Double.valueOf(in.readLine());
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
}
