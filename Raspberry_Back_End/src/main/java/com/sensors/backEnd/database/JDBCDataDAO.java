package com.sensors.backEnd.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sensors.backEnd.Data;

public class JDBCDataDAO implements DataDAO {
	private Connection connection;
	private Statement statement;

	@Override
	public void insert(Data data) {
		try {
			connection = ConnectionFactory.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO sensors.data (temperature ,humidity,moisiture,luminosity) VALUES (?,?,?,?)");
			preparedStatement.setDouble(1, data.getTemperature());
			preparedStatement.setDouble(2, data.getHumidity());
			preparedStatement.setDouble(3, data.getMoisiture());
			preparedStatement.setDouble(4, data.getLuminosity());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void createNewTable() {
		String sql = "CREATE TABLE IF NOT EXISTS data (\n"
				+ "	id integer PRIMARY KEY AUTO_INCREMENT,\n"
				+ "	temperature double NOT NULL,\n"
				+ "	humidity double NOT NULL,\n"
				+ "	moisiture double NOT NULL,\n"
				+ "	luminosity double NOT NULL,\n"
				+ "	date TIMESTAMP DEFAULT CURRENT_TIMESTAMP\n" + ");";
		try {
			connection = ConnectionFactory.getConnection();
			Statement statement = connection.createStatement();
			statement.execute(sql, 1);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
