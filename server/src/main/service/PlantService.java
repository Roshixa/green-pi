package main.service;

import main.beans.Plant;

public interface PlantService {
    boolean add (String userEmail, String dbAddress, String dbUsername, String dbPassword, Integer dbPort, String name, String description);

    Plant find(String dbAddress, Integer port);
}
