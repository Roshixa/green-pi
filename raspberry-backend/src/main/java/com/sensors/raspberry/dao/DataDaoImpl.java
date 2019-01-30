package com.sensors.raspberry.dao;

import com.sensors.raspberry.beans.Data;
import com.sensors.raspberry.utils.DbConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataDaoImpl implements DataDao {
    public final static String HOSTNAME = "jdbc:mysql://localhost/sensors";
    public final static String USERNAME = "Soukayna";
    public final static String PASSWORD = "1111";

    @Override
    public boolean save(Data data) {
        Connection connection = DbConnectionUtils.createMySqlConnection(HOSTNAME, USERNAME, PASSWORD);
        if (connection != null) {
            try (PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO sensors.data (temperature ,humidity,moisiture,luminosity) VALUES (?,?,?,?)")) {
                preparedStatement.setDouble(1, data.getTemperature());
                preparedStatement.setDouble(2, data.getHumidity());
                preparedStatement.setDouble(3, data.getMoisture());
                preparedStatement.setDouble(4, data.getLuminosity());
                preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return true;
        }
        return false;
    }

}
