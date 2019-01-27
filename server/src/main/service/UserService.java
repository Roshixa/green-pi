package main.service;

public interface UserService {

    void login(String email, String password);

    void signUp(String name, String email, String password, String passwordConfirmation);
}
