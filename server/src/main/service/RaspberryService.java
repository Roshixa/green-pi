package main.service;

import main.beans.Plant;
import main.beans.Reading;
import main.beans.Readings;

import java.util.List;

public interface RaspberryService {
    Boolean checkConnection(Plant plant);

    Reading getLastData(Plant plant);

    Readings geAllLastData(Plant plant);

    List<Reading> getLastData(List<Plant> plants);
}
