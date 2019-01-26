package main.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import main.utils.StringUtils;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    private Integer id;
    private String email;
    private String password;
    private String name;

    public User(Integer id, String email, String password, String name) {
        this.id = id;
        this.email = email;
        this.password = StringUtils.encrypt(password);
        this.name = name;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
