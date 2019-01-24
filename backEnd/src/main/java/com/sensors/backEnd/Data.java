package com.sensors.backEnd;

import java.util.Date;

public class Data {
	
	Integer id;
	Double temperature;
	Double humidity;
	Double moisiture;
	Double light;
	Date date;
	
	public Data(Integer id, Double temperature, Double humidity,
			Double moisiture, Double light, Date date) {
		this.id = id;
		this.temperature = temperature;
		this.humidity = humidity;
		this.moisiture = moisiture;
		this.light = light;
		this.date = date;
	}

	public Data() {
		super();
	}
	
}
