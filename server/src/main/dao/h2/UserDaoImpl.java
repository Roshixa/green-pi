package main.dao.h2;

import main.beans.User;
import main.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public User find(String email) {
        return null;
    }

    @Override
    public boolean save(User user) {
        return false;
    }
}
