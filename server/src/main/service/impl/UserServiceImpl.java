package main.service.impl;

import main.service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public boolean login(String email, String password) {
        return false;
    }

    @Override
    public boolean signUp(String name, String email, String password, String passwordConfirmation) {
        return false;
    }
}
