package main.dao;

import main.beans.User;

public interface UserDao {
    User find(String email);

    boolean save(User user);
}
