package com.sensors.backEnd.beans;

import java.util.Date;

public class Data {
    private Double temperature;
    private Double humidity;
    private Double moisture;
    private Double luminosity;
    private Date date;

    public Data(Double temperature, Double humidity, Double moisture,
                Double luminosity) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.moisture = moisture;
        this.luminosity = luminosity;
        this.date = new Date();
    }

    public Data() {
        super();
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getMoisture() {
        return moisture;
    }

    public void setMoisture(Double moisture) {
        this.moisture = moisture;
    }

    public Double getLuminosity() {
        return luminosity;
    }

    public void setLuminosity(Double luminosity) {
        this.luminosity = luminosity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Data [temperature=" + temperature + ", humidity=" + humidity
                + ", moisiture=" + moisture + ", luminosity=" + luminosity
                + ", date=" + date + "]";
    }

}
