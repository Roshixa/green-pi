package com.sensors.raspberry;

import com.sensors.raspberry.service.DataServiceImpl;

import java.util.Timer;

public class App {
    public static void main(String[] args) {
        Timer timer = new Timer();
        DataServiceImpl dataService = new DataServiceImpl();
        timer.scheduleAtFixedRate(dataService, 0, 1000);
    }
}
