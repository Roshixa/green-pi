package main.dao;

import main.beans.Plant;
import main.beans.Reading;
import main.beans.Readings;

public interface ReadingDao {

    Reading getData(String hostname, String username, String password);

    Readings getDatas(String hostname, String username, String password);
}
