package main.dao.h2;

import main.beans.User;
import main.dao.UserDao;
import main.utils.DbConnectionsUtils;
import main.utils.StringUtils;

import java.sql.*;

public class UserDaoImpl implements UserDao {
    public final static String HOSTNAME = "jdbc:h2:file:~/greenpi;DB_CLOSE_ON_EXIT=FALSE;AUTO_RECONNECT=TRUE";

    @Override
    public User find(String email) {
        Connection connection = DbConnectionsUtils.createH2Connection(HOSTNAME);
        if (connection != null) {
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM User WHERE email='" + email + "'");
                if (resultSet.next()) {
                    User user = new User();
                    user.setEmail(resultSet.getString("email"));
                    user.setPassword(resultSet.getString("password"));
                    user.setName(resultSet.getString("name"));
                    return user;
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
    public boolean save(User user) {
        Connection connection = DbConnectionsUtils.createH2Connection(HOSTNAME);
        if (connection != null) {
            try (PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO User VALUES (?,?,?)")) {
                preparedStatement.setString(1, user.getEmail());
                preparedStatement.setString(2, StringUtils.encrypt(user.getPassword()));
                preparedStatement.setString(3, user.getName());
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
