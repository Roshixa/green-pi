package main.service;

import main.beans.Plant;
import main.beans.User;

import java.util.List;

public interface PlantService {
    boolean add(String userEmail, String dbAddress, String dbUsername, String dbPassword, Integer dbPort, String name, String description);

    Plant find(String hash);

    List<Plant> findByUserEmail(User user);
}
