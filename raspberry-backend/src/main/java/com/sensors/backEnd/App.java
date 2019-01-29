package com.sensors.backEnd;

import com.sensors.backEnd.service.DataServiceImpl;

import java.util.Timer;

public class App {
    public static void main(String[] args) {
        Timer timer = new Timer();
        DataServiceImpl dataService = new DataServiceImpl();
        timer.scheduleAtFixedRate(dataService, 0, 1000);
    }
}
