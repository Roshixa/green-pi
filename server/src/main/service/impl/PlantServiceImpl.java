package main.service.impl;

import main.beans.Plant;
import main.service.PlantService;

public class PlantServiceImpl implements PlantService {
    @Override
    public boolean add(String userEmail, String dbAddress, String dbUsername, String dbPassword, Integer dbPort, String name, String description) {
        return false;
    }

    @Override
    public Plant find(String dbAddress, Integer port) {
        return null;
    }
}
