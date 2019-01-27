package test.dao;

import main.beans.User;
import main.dao.UserDao;
import main.dao.h2.UserDaoImpl;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class UserDaoTest {
    private static final String EXISTANT_USER = "a@gmail.com";
    private static UserDao userDao;

    @BeforeClass
    public static void init() {
        userDao = new UserDaoImpl();
    }

    @AfterClass
    public static void finish() {
        //userDao.cleanTestUsers();
    }

    @Test
    public void findUser() {
        User user = userDao.find(EXISTANT_USER);
        assertNotNull(user);

        user = userDao.find(EXISTANT_USER + new Random().nextInt());
        assertNull(user);
    }

    @Test
    public void saveUser() {
        User user = new User(EXISTANT_USER, " ", " ");
        assertFalse(userDao.save(user));

        user = new User(new Random().nextInt() + EXISTANT_USER + "_test", " ", " ");
        assertTrue(userDao.save(user));
    }
}
