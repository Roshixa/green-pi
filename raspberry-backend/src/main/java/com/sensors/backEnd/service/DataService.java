package com.sensors.backEnd.service;

public interface DataService {
    boolean add(Double temperature, Double humidity, Double moisture, Double luminosity);
}
