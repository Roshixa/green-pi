package com.sensors.backEnd;

import java.util.Date;

public class Data {
	Integer id;
	Double temperature;
	Double humidity;
	Double moisiture;
	Double luminosity;
	Date date;

	public Data(Double temperature, Double humidity, Double moisiture,
			Double luminosity) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.moisiture = moisiture;
		this.luminosity = luminosity;
		this.date = new Date();
	}

	public Data() {
		super();
	}

	@Override
	public String toString() {
		return "Data [temperature=" + temperature + ", humidity=" + humidity
				+ ", moisiture=" + moisiture + ", luminosity=" + luminosity
				+ ", date=" + date + "]";
	}

}
