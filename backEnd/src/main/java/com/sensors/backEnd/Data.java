package com.sensors.backEnd;

import java.util.Date;

public class Data {
	
	Integer id;
	Double temperature;
	Double humidity;
	Double moisiture;
	Double luminosity;
	Date date;
	
	public Data(Integer id, Double temperature, Double humidity,
			Double moisiture, Double luminosity, Date date) {
		this.id = id;
		this.temperature = temperature;
		this.humidity = humidity;
		this.moisiture = moisiture;
		this.luminosity = luminosity;
		this.date = date;
	}

	public Data() {
		super();
	}
	
}
