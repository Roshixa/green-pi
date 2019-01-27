package main.dao.mysql;

import main.beans.Reading;
import main.beans.Readings;
import main.dao.ReadingDao;
import main.utils.DbConnectionsUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadingDaoImpl implements ReadingDao {
    static final Integer LIMIT_NB_DATA = 100;

    @Override
    public Reading getData(String hostname, String username, String password) {
        Connection connection = DbConnectionsUtils.createMySqlConnection(hostname, username, password);
        if (connection != null) {
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM data ORDER BY id DESC LIMIT 1");
                if (resultSet.next()) {
                    Reading reading = new Reading();
                    reading.setTemperature(resultSet.getDouble("temperature"));
                    reading.setHumidity(resultSet.getDouble("humidity"));
                    reading.setMoisture(resultSet.getDouble("moisiture"));
                    reading.setLuminosity(resultSet.getDouble("luminosity"));
                    return reading;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public Readings getDatas(String hostname, String username, String password) {
        Connection connection = DbConnectionsUtils.createMySqlConnection(hostname, username, password);
        if (connection != null) {
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM data ORDER BY id DESC LIMIT " + LIMIT_NB_DATA);
                Readings readings = new Readings();
                while (resultSet.next()) {
                    readings.getHumidity().add(resultSet.getDouble("temperature"));
                    readings.getHumidity().add(resultSet.getDouble("humidity"));
                    readings.getMoisture().add(resultSet.getDouble("moisiture"));
                    readings.getLuminosity().add(resultSet.getDouble("luminosity"));
                }
                return readings;
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
