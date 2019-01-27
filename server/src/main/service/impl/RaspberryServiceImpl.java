package main.service.impl;

import main.beans.Plant;
import main.beans.Reading;
import main.beans.Readings;
import main.dao.ReadingDao;
import main.dao.mysql.ReadingDaoImpl;
import main.service.RaspberryService;
import main.utils.DbConnectionsUtils;
import main.utils.StringUtils;

import java.sql.Connection;

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
    public String getLastData(Plant plant) {
        if (checkConnection(plant)) {
            String hostname = "jdbc:mysql://" + plant.getDbAddress() + ":" + plant.getDbPort() + "/sensors";
            Reading reading = readingDao.getData(hostname, plant.getDbUsername(), plant.getDbPassword());
            if (reading != null) {
                return StringUtils.toJSON(reading);
            }
        }
        return null;
    }

    @Override
    public String geAllLastData(Plant plant) {
        if (checkConnection(plant)) {
            String hostname = "jdbc:mysql://" + plant.getDbAddress() + ":" + plant.getDbPort() + "/sensors";
            Readings readings = readingDao.getDatas(hostname, plant.getDbUsername(), plant.getDbPassword());
            if (readings != null) {
                return StringUtils.toJSON(readings);
            }
        }
        return null;
    }
}
