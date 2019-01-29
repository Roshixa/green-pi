package com.sensors.backEnd.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnectionUtils {

    private DbConnectionUtils() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection createMySqlConnection(String hostname, String username, String password) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(hostname, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void createTable(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS data"
                + "(id integer PRIMARY KEY AUTO_INCREMENT, "
                + "	temperature double NOT NULL,"
                + "	humidity double NOT NULL,"
                + "	moisiture double NOT NULL,"
                + "	luminosity double NOT NULL,"
                + "	date TIMESTAMP DEFAULT CURRENT_TIMESTAMP);";
        try {
            statement.execute(sql, Statement.RETURN_GENERATED_KEYS);
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
