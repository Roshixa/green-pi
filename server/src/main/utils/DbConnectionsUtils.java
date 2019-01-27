package main.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public final class DbConnectionsUtils {

    private DbConnectionsUtils() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void createTables(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS User" +
                "(email VARCHAR(255) NOT NULL, " +
                " password VARCHAR(255) NOT NULL, " +
                " name VARCHAR(255), " +
                " PRIMARY KEY ( email ))";
        statement.executeUpdate(sql);
        statement.close();
        statement = connection.createStatement();
        sql = "CREATE TABLE IF NOT EXISTS Plant" +
                "(userEmail VARCHAR(255) NOT NULL," +
                " dbAddress VARCHAR(255) NOT NULL, " +
                " dbUsername VARCHAR(255) NOT NULL, " +
                " dbPassword VARCHAR(255) NOT NULL, " +
                " dbPort INTEGER DEFAULT 3306, " +
                " name VARCHAR(255) NOT NULL, " +
                " description TEXT NOT NULL, " +
                " PRIMARY KEY (dbAddress,dbPort))";
        statement.executeUpdate(sql);
        statement.close();
    }
    public static Connection createH2Connection(String hostname) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(hostname);
            createTables(connection);
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
