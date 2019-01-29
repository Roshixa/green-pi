package com.sensors.backEnd.dao;

import com.sensors.backEnd.Data;

public interface DataDao {
    void createNewTable();

    void insert(Data data);
}
