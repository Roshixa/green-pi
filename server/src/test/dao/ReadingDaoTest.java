package test.dao;

import main.beans.Reading;
import main.beans.Readings;
import main.dao.ReadingDao;
import main.dao.mysql.ReadingDaoImpl;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class ReadingDaoTest {
    private static final String EXISTANT_HOSTNAME = "jdbc:mysql://raspberrypi:3306/sensors";
    private static final String EXISTANT_DB_USERNAME = "Soukayna";
    private static final String EXISTANT_DB_PASSWORD = "1111";
    private static ReadingDao readingDao ;

    @BeforeClass
    public static void init() {
        readingDao = new ReadingDaoImpl();
    }

    @AfterClass
    public static void finish() {
        //readingDAO.cleanTestUsers();
    }

    @Test
    public void getReading() {
        Reading reading = readingDao.getReading(EXISTANT_HOSTNAME, EXISTANT_DB_USERNAME, EXISTANT_DB_PASSWORD);
        assertNotNull(reading);
        assertNotNull(reading.getHumidity());
        assertNotNull(reading.getLuminosity());
        assertNotNull(reading.getMoisture());
        assertNotNull(reading.getTemperature());

        reading = readingDao.getReading(EXISTANT_HOSTNAME + new Random().nextInt(), EXISTANT_DB_USERNAME, EXISTANT_DB_PASSWORD);
        assertNull(reading);
    }

    @Test
    public void getReadings() {
        Readings readings = readingDao.getReadings(EXISTANT_HOSTNAME, EXISTANT_DB_USERNAME, EXISTANT_DB_PASSWORD);
        assertNotNull(readings);
        assertFalse(readings.getHumidity().isEmpty());
        assertFalse(readings.getLuminosity().isEmpty());
        assertFalse(readings.getTemperature().isEmpty());
        assertFalse(readings.getMoisture().isEmpty());

        readings = readingDao.getReadings(EXISTANT_HOSTNAME + new Random().nextInt(), EXISTANT_DB_USERNAME, EXISTANT_DB_PASSWORD);
        assertNull(readings);
    }
}
