package main.service.impl;

import main.beans.Plant;
import main.beans.Reading;
import main.beans.Readings;
import main.dao.ReadingDao;
import main.dao.mysql.ReadingDaoImpl;
import main.service.RaspberryService;
import main.utils.DbConnectionsUtils;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class RaspberryServiceImpl implements RaspberryService {
    private ReadingDao readingDao;

    public RaspberryServiceImpl() {
        readingDao = new ReadingDaoImpl();
    }

    @Override
    public Boolean checkConnection(Plant plant) {
        String hostname = "jdbc:mysql://" + plant.getDbAddress() + ":" + plant.getDbPort() + "/sensors";
        Connection connection = DbConnectionsUtils.createMySqlConnection(hostname, plant.getDbUsername(), plant.getDbPassword());
        return connection != null;
    }

    @Override
    public Reading getLastData(Plant plant) {
        if (checkConnection(plant)) {
            String hostname = "jdbc:mysql://" + plant.getDbAddress() + ":" + plant.getDbPort() + "/sensors";
            Reading reading = readingDao.getData(hostname, plant.getDbUsername(), plant.getDbPassword());
            return reading;
        }
        return null;
    }

    @Override
    public Readings geAllLastData(Plant plant) {
        if (checkConnection(plant)) {
            String hostname = "jdbc:mysql://" + plant.getDbAddress() + ":" + plant.getDbPort() + "/sensors";
            Readings readings = readingDao.getDatas(hostname, plant.getDbUsername(), plant.getDbPassword());
            return readings;
        }
        return null;
    }

    @Override
    public List<Reading> getLastData(List<Plant> plants) {
        List<Reading> readings = new ArrayList<>();
        for (Plant plant : plants) {
            readings.add(getLastData(plant));
        }
        return readings;
    }
}
