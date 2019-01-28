package test.utils;

import main.dao.h2.UserDaoImpl;
import main.utils.DbConnectionsUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class DbConnectionsUtilsTest {


    @Test
    public void createH2Connection() {
        final String hostname = UserDaoImpl.HOSTNAME;
        try {
            Connection connection = DbConnectionsUtils.createH2Connection(hostname);
            ResultSet resultSet = connection.getMetaData().getTables(null, null, "Plant", null);
            assertNotNull(resultSet.next());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createMySqlConnection() {
        final String hostname = "jdbc:mysql://raspberrypi:3306/sensors";
        try {
            Connection connection = DbConnectionsUtils.createMySqlConnection(hostname, "Soukayna", "1111");
            ResultSet resultSet = connection.getMetaData().getTables(null, null, "Data", null);
            assertNotNull(resultSet.next());

            connection = DbConnectionsUtils.createMySqlConnection(hostname, "root", "2222");
            assertNull(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
