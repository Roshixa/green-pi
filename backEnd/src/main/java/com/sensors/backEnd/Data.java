package com.sensors.backEnd;

import java.util.Date;

public class Data {
	private Double temperature;
	private Double humidity;
	private Double moisiture;
	private Double luminosity;
	private Date date;

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
	
	
	public Double getTemperature() {
		return temperature;
	}

	public Double getHumidity() {
		return humidity;
	}

	public Double getMoisiture() {
		return moisiture;
	}

	public Double getLuminosity() {
		return luminosity;
	}

	public Date getDate() {
		return date;
	}

	@Override
	public String toString() {
		return "Data [temperature=" + temperature + ", humidity=" + humidity
				+ ", moisiture=" + moisiture + ", luminosity=" + luminosity
				+ ", date=" + date + "]";
	}

}
