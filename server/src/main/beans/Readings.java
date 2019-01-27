package main.beans;

import java.util.ArrayList;
import java.util.List;

public class Readings {
    private List<Double> luminosity;
    private List<Double> humidity;
    private List<Double> moisture;
    private List<Double> temperature;

    public Readings(List<Double> luminosity, List<Double> humidity, List<Double> moisture, List<Double> temperature) {
        this.luminosity = luminosity;
        this.humidity = humidity;
        this.moisture = moisture;
        this.temperature = temperature;
    }

    public Readings() {
        luminosity = new ArrayList<>();
        humidity = new ArrayList<>();
        moisture = new ArrayList<>();
        temperature = new ArrayList<>();
    }

    public List<Double> getLuminosity() {
        return luminosity;
    }

    public void setLuminosity(List<Double> luminosity) {
        this.luminosity = luminosity;
    }

    public List<Double> getHumidity() {
        return humidity;
    }

    public void setHumidity(List<Double> humidity) {
        this.humidity = humidity;
    }

    public List<Double> getMoisture() {
        return moisture;
    }

    public void setMoisture(List<Double> moisture) {
        this.moisture = moisture;
    }

    public List<Double> getTemperature() {
        return temperature;
    }

    public void setTemperature(List<Double> temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Readings{" +
                "luminosity=" + luminosity +
                ", humidity=" + humidity +
                ", moisture=" + moisture +
                ", temperature=" + temperature +
                '}';
    }
}
