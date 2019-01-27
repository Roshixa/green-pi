package main.service.impl;

import main.beans.User;
import main.dao.UserDao;
import main.dao.h2.UserDaoImpl;
import main.service.UserService;
import main.utils.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Objects;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl() {
        this.userDao = new UserDaoImpl();
    }

    @Override
    public boolean login(String email, String password, HttpSession session) {
        User user = userDao.find(email);
        if (user != null && (Objects.equals(user.getPassword(), StringUtils.encrypt(password)))) {
            saveSessionUser(user, session);
            return true;
        }
        return false;
    }

    @Override
    public boolean signUp(String name, String email, String password, String passwordConfirmation) {
        if (password.equals(passwordConfirmation)) {
            User user = new User(email, password, name);
            return userDao.save(user);
        }
        return false;
    }

    @Override
    public User getSessionUser(HttpSession httpSession) {
        return (User) httpSession.getAttribute("user");
    }

    @Override
    public void saveSessionUser(User user, HttpSession httpSession) {
        httpSession.setAttribute("user", user);
    }

    @Override
    public boolean hasLoggedIn(HttpSession httpSession) {
        return getSessionUser(httpSession) != null;
    }
}
