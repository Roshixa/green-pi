package main.dao;

import main.beans.Plant;
import main.beans.User;

import java.util.List;

public interface PlantDao {
    Plant find(String address, Integer port);

    List<Plant> find(User user);

    boolean save(Plant plant);
}
