package test.dao;

import main.beans.Plant;
import main.beans.User;
import main.dao.PlantDao;
import main.dao.UserDao;
import main.dao.h2.PlantDaoImpl;
import main.dao.h2.UserDaoImpl;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class PlantDaoTest {
    private static final String EXISTANT_DB_ADDRESS = "127.0.0.1";
    private static final Integer EXISTANT_DB_PORT = 3306;
    private static final String EXISTANT_USER_EMAIL = "a@gmail.com";
    private static PlantDao plantDao;

    @BeforeClass
    public static void init() {
        plantDao = new PlantDaoImpl();
    }

    @AfterClass
    public static void finish() {
        //plantDao.cleanTestPlants();
    }

    @Test
    public void find() {
        Plant plant = plantDao.find(EXISTANT_DB_ADDRESS, EXISTANT_DB_PORT);
        assertNotNull(plant);

        plant = plantDao.find(EXISTANT_DB_ADDRESS, EXISTANT_DB_PORT + new Random().nextInt());
        assertNull(plant);

        plant = plantDao.find(EXISTANT_DB_ADDRESS + new Random().nextInt(), EXISTANT_DB_PORT);
        assertNull(plant);
    }

    @Test
    public void findByUserEmail() {
        UserDao userDao = new UserDaoImpl();
        List<Plant> plants = plantDao.find(userDao.find(EXISTANT_USER_EMAIL));
        assertNotNull(plants);
        assertTrue(plants.size() > 0);

        plants = plantDao.find(new User(" " + new Random().nextFloat(), " ", " "));
        assertEquals(0, plants.size());
    }

    @Test
    public void savePlant() {
        Plant plant = new Plant(EXISTANT_USER_EMAIL, EXISTANT_DB_ADDRESS, " ", " ", EXISTANT_DB_PORT, " ", " ");
        assertFalse(plantDao.save(plant));

        plant = new Plant(" " + new Random().nextInt(), new Random().nextInt() + EXISTANT_DB_ADDRESS,
                " ", " ", EXISTANT_DB_PORT, " ", " ");
        assertTrue(plantDao.save(plant));

        plant = new Plant(" " + new Random().nextInt(), EXISTANT_DB_ADDRESS, " ", " ",
                new Random().nextInt() + EXISTANT_DB_PORT, " ", " ");
        assertTrue(plantDao.save(plant));
    }

}
