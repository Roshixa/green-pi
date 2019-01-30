package com.sensors.raspberry.dao;

import com.sensors.raspberry.beans.Data;

public interface DataDao {
    boolean save(Data data);
}
