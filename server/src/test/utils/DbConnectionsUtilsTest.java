package test.utils;

import main.utils.DbConnectionsUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class DbConnectionsUtilsTest {
    private void createTables(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS User" +
                "(id INTEGER AUTO_INCREMENT, " +
                " email VARCHAR(255) NOT NULL, " +
                " password VARCHAR(255) NOT NULL, " +
                " name VARCHAR(255), " +
                " PRIMARY KEY ( id ))";
        statement.executeUpdate(sql);
        statement.close();
        statement = connection.createStatement();
        sql = "CREATE TABLE IF NOT EXISTS Plant" +
                "(id INTEGER AUTO_INCREMENT, " +
                " userId INTEGER NOT NULL," +
                " dbAddress VARCHAR(255) NOT NULL, " +
                " dbUsername VARCHAR(255) NOT NULL, " +
                " dbPassword VARCHAR(255) NOT NULL, " +
                " dbPort INTEGER DEFAULT 3306, " +
                " name VARCHAR(255) NOT NULL, " +
                " description TEXT NOT NULL, " +
                " PRIMARY KEY ( id ))";
        statement.executeUpdate(sql);
        statement.close();
    }

    @Test
    public void createH2Connection() {
        final String hostname = "jdbc:h2:file:~/greenpi;DB_CLOSE_ON_EXIT=FALSE;AUTO_RECONNECT=TRUE";
        try {
            Connection connection = DbConnectionsUtils.createH2Connection(hostname);
            createTables(connection);

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
