package test.service;

import main.service.UserService;
import main.service.impl.UserServiceImpl;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserServiceTest {
    private static final String EXISTANT_USER_EMAIL = "a@gmail.com";
    private static final String EXISTANT_USER_PASSWORD = "pass";
    private static final String USER_NAME = "_test";

    private static UserService userService;

    @BeforeClass
    public static void init() {
        userService = new UserServiceImpl();
    }

    @Test
    public void login() {
        Boolean loggedIn = userService.login(EXISTANT_USER_EMAIL, EXISTANT_USER_PASSWORD);
        assertTrue(loggedIn);

        loggedIn = userService.login(EXISTANT_USER_EMAIL + new Random().nextInt(), EXISTANT_USER_PASSWORD);
        assertFalse(loggedIn);

        loggedIn = userService.login(EXISTANT_USER_EMAIL, EXISTANT_USER_PASSWORD + new Random().nextInt());
        assertFalse(loggedIn);

        loggedIn = userService.login(EXISTANT_USER_EMAIL + new Random().nextInt(), EXISTANT_USER_PASSWORD + new Random().nextInt());
        assertFalse(loggedIn);
    }

    @Test
    public void signUp() {
        Boolean signedUp = userService.signUp(USER_NAME, EXISTANT_USER_EMAIL, EXISTANT_USER_PASSWORD, EXISTANT_USER_PASSWORD);
        assertFalse(signedUp);

        signedUp = userService.signUp(USER_NAME, EXISTANT_USER_EMAIL + new Random().nextInt(), EXISTANT_USER_PASSWORD, EXISTANT_USER_PASSWORD);
        assertTrue(signedUp);

        signedUp = userService.signUp(USER_NAME, EXISTANT_USER_EMAIL + new Random().nextInt(), EXISTANT_USER_PASSWORD, EXISTANT_USER_PASSWORD + new Random().nextInt());
        assertFalse(signedUp);
    }
}
