package main.beans;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Reading {
    private Double luminosity;
    private Double humidity;
    private Double moisture;
    private Double temperature;

    public Reading(Double luminosity, Double humidity, Double moisture, Double temperature) {
        this.luminosity = luminosity;
        this.humidity = humidity;
        this.moisture = moisture;
        this.temperature = temperature;
    }

    public Reading() {
    }

    public Double getLuminosity() {
        return luminosity;
    }

    public void setLuminosity(Double luminosity) {
        this.luminosity = luminosity;
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

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Reading{" +
                "luminosity=" + luminosity +
                ", humidity=" + humidity +
                ", moisture=" + moisture +
                ", temperature=" + temperature +
                '}';
    }
}
