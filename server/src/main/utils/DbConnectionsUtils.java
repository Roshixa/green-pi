package main.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DbConnectionsUtils {

    private DbConnectionsUtils() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection createH2Connection(String hostname) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(hostname);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static Connection createMySqlConnection(String hostname, String user, String password) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(hostname, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
