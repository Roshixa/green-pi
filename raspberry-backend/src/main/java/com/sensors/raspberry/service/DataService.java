package com.sensors.raspberry.service;

public interface DataService {
    boolean add(Double temperature, Double humidity, Double moisture, Double luminosity);
}
