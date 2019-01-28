package test.service;

import main.beans.User;
import main.service.UserService;
import main.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.servlet.http.HttpSession;
import java.util.Random;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {
    private static final String EXISTANT_USER_EMAIL = "a@gmail.com";
    private static final String EXISTANT_USER_PASSWORD = "pass";
    private static final String USER_NAME = "_test";

    private static UserService userService;
    private static HttpSession session;

    @BeforeClass
    public static void init() {
        userService = new UserServiceImpl();
    }

    @Before
    public void initBeforeTests() {
        session = mock(HttpSession.class);
    }

    @Test
    public void login() {
        Boolean loggedIn = userService.login(EXISTANT_USER_EMAIL, EXISTANT_USER_PASSWORD, session);
        assertTrue(loggedIn);

        loggedIn = userService.login(EXISTANT_USER_EMAIL + new Random().nextInt(), EXISTANT_USER_PASSWORD, session);
        assertFalse(loggedIn);

        loggedIn = userService.login(EXISTANT_USER_EMAIL, EXISTANT_USER_PASSWORD + new Random().nextInt(), session);
        assertFalse(loggedIn);

        loggedIn = userService.login(EXISTANT_USER_EMAIL + new Random().nextInt(),
                EXISTANT_USER_PASSWORD + new Random().nextInt(), session);
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

    @Test
    public void getSessionUser() {
        when(session.getAttribute("user")).thenReturn(null).thenReturn(new User());
        assertNull(userService.getSessionUser(session));
        assertNotNull(userService.getSessionUser(session));
    }

    @Test
    public void hasLoggedIn() {
        when(session.getAttribute("user")).thenReturn(null).thenReturn(new User());
        assertFalse(userService.hasLoggedIn(session));
        assertTrue(userService.hasLoggedIn(session));
    }
}
