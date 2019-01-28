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
    private static final String EXISTANT_USER_EMAIL = "a@gmail.com";
    private static final String EXISTANT_USER_PASSWORD = "pass";
    private static final String USER_NAME = "_test";
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
        User user = userDao.find(EXISTANT_USER_EMAIL);
        assertNotNull(user);

        user = userDao.find(EXISTANT_USER_EMAIL + new Random().nextInt());
        assertNull(user);
    }

    @Test
    public void saveUser() {
        User user = new User(EXISTANT_USER_EMAIL, EXISTANT_USER_PASSWORD, USER_NAME);
        assertFalse(userDao.save(user));

        user = new User(new Random().nextInt() + EXISTANT_USER_EMAIL + "_test", " ", " ");
        assertTrue(userDao.save(user));
    }
}
