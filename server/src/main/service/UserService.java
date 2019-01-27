package main.service;

public interface UserService {

    boolean login(String email, String password);

    boolean signUp(String name, String email, String password, String passwordConfirmation);
}
