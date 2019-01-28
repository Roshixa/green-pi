package main.service;

import main.beans.User;

import javax.servlet.http.HttpSession;

public interface UserService {

    boolean login(String email, String password, HttpSession session);

    boolean signUp(String name, String email, String password, String passwordConfirmation);

    User getSessionUser(HttpSession httpSession);

    void saveSessionUser(User user, HttpSession httpSession);

    boolean hasLoggedIn(HttpSession httpSession);

    String getUserEmail (HttpSession session);
}
