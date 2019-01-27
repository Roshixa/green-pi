package main.dao.h2;

import main.beans.Plant;
import main.beans.User;
import main.dao.PlantDao;
import main.utils.DbConnectionsUtils;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class PlantDaoImpl implements PlantDao {

    @Override
    public Plant find(String address, Integer port) {
        Connection connection = DbConnectionsUtils.createH2Connection(UserDaoImpl.HOSTNAME);
        if (connection != null) {
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Plant WHERE dbAddress='" + address + "' AND dbPort='" + port + "'");
                if (resultSet.next()) {
                    return createPlantFromResultSet(resultSet);
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
    public List<Plant> find(User user) {
        Connection connection = DbConnectionsUtils.createH2Connection(UserDaoImpl.HOSTNAME);
        if (connection != null) {
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Plant WHERE userEmail='" + user.getEmail() + "'");
                List<Plant> plants = new LinkedList<>();
                while (resultSet.next()) {
                    plants.add(createPlantFromResultSet(resultSet));
                }
                return plants;
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
    public boolean save(Plant plant) {
        Connection connection = DbConnectionsUtils.createH2Connection(UserDaoImpl.HOSTNAME);
        if (connection != null) {
            try (PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO Plant VALUES (?,?,?,?,?,?,?)")) {
                preparedStatement.setString(1, plant.getUserEmail());
                preparedStatement.setString(2, plant.getDbAddress());
                preparedStatement.setString(3, plant.getDbUsername());
                preparedStatement.setString(4, plant.getDbPassword());
                preparedStatement.setInt(5, plant.getDbPort());
                preparedStatement.setString(6, plant.getName());
                preparedStatement.setString(7, plant.getDescription());
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

    private Plant createPlantFromResultSet(ResultSet resultSet) {
        Plant plant = new Plant();
        try {
            plant.setUserEmail(resultSet.getString("userEmail"));
            plant.setDbAddress(resultSet.getString("dbAddress"));
            plant.setDbPort(resultSet.getInt("dbPort"));
            plant.setDbUsername(resultSet.getString("dbUsername"));
            plant.setDbPassword(resultSet.getString("dbPassword"));
            plant.setName(resultSet.getString("name"));
            plant.setDescription(resultSet.getString("description"));
            return plant;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
