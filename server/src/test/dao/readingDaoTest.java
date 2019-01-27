package test.dao;

import main.beans.Reading;
import main.beans.Readings;
import main.dao.ReadingDao;
import main.dao.UserDao;
import main.dao.h2.UserDaoImpl;
import main.dao.mysql.ReadingDaoImpl;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class readingDaoTest {
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
    public void getData(){
        Reading reading = readingDao.getData(EXISTANT_HOSTNAME,EXISTANT_DB_USERNAME,EXISTANT_DB_PASSWORD);
        assertNotNull(reading);

        reading = readingDao.getData(EXISTANT_HOSTNAME + new Random().nextInt() ,EXISTANT_DB_USERNAME,EXISTANT_DB_PASSWORD);
        assertNull(reading);
    }

    @Test
    public void getDatas(){
        Readings readings = readingDao.getDatas(EXISTANT_HOSTNAME,EXISTANT_DB_USERNAME,EXISTANT_DB_PASSWORD);
        assertTrue(readings.getHumidity().size()>0);

        readings = readingDao.getDatas(EXISTANT_HOSTNAME + new Random().nextInt() ,EXISTANT_DB_USERNAME,EXISTANT_DB_PASSWORD);
        assertNull(readings);
    }
}
