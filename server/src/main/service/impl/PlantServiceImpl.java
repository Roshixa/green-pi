package main.service.impl;

import main.beans.Plant;
import main.dao.PlantDao;
import main.dao.h2.PlantDaoImpl;
import main.service.PlantService;

import static main.utils.StringUtils.encrypt;

public class PlantServiceImpl implements PlantService {
    private PlantDao plantDao;

    public PlantServiceImpl() {
        this.plantDao = new PlantDaoImpl();
    }

    @Override
    public boolean add(String userEmail, String dbAddress, String dbUsername, String dbPassword, Integer dbPort, String name, String description) {
        String hash = encrypt(dbAddress + dbPort);
        Plant plant = new Plant(userEmail, dbAddress, dbUsername, dbPassword, dbPort, name, description, hash);
        return plantDao.save(plant);
    }

    @Override
    public Plant find(String dbAddress, Integer port) {
        return plantDao.find(dbAddress,port);
    }
}
