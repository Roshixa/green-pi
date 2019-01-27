package main.beans;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Plant {
    private Integer id;
    private Integer userId;
    private String dbAddress;
    private String dbUsername;
    private String dbPassword;
    private Integer dbPort;
    private String name;
    private String description;

    public Plant() {
    }

    public Plant(Integer id, Integer userId, String dbAddress, String dbUsername, String dbPassword, Integer dbPort, String name, String description) {
        this.id = id;
        this.userId = userId;
        this.dbAddress = dbAddress;
        this.dbUsername = dbUsername;
        this.dbPassword = dbPassword;
        this.dbPort = dbPort;
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDbAddress() {
        return dbAddress;
    }

    public void setDbAddress(String dbAddress) {
        this.dbAddress = dbAddress;
    }

    public String getDbUsername() {
        return dbUsername;
    }

    public void setDbUsername(String dbUsername) {
        this.dbUsername = dbUsername;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public Integer getDbPort() {
        return dbPort;
    }

    public void setDbPort(Integer dbPort) {
        this.dbPort = dbPort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "id=" + id +
                ", userId=" + userId +
                ", dbAddress='" + dbAddress + '\'' +
                ", dbUsername='" + dbUsername + '\'' +
                ", dbPassword='" + dbPassword + '\'' +
                ", dbPort=" + dbPort +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
