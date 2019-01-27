package main.service;

import main.beans.Plant;

public interface RaspberryService {
    Boolean checkConnection(Plant plant);

    String getLastData(Plant plant);

    String geAllLastData(Plant plant);

}
