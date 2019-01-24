package com.sensors.backEnd.database;

import com.sensors.backEnd.Data;

public interface DataDAO {
	public void createNewTable();
	public void insert(Data data);
}
