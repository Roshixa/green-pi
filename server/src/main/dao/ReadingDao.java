package main.dao;

import main.beans.Reading;
import main.beans.Readings;

public interface ReadingDao {

    Reading getReading(String hostname, String username, String password);

    Readings getReadings(String hostname, String username, String password);
}

