package main.beans;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Plant {
    private String userEmail;
    private String dbAddress;
    private String dbUsername;
    private String dbPassword;
    private Integer dbPort;
    private String name;
    private String description;
    private String hash;

    public Plant() {
    }

    public Plant(String userEmail, String dbAddress, String dbUsername, String dbPassword, Integer dbPort, String name, String description, String hash) {
        this.userEmail = userEmail;
        this.dbAddress = dbAddress;
        this.dbUsername = dbUsername;
        this.dbPassword = dbPassword;
        this.dbPort = dbPort;
        this.name = name;
        this.description = description;
        this.hash = hash;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
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

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "userEmail='" + userEmail + '\'' +
                ", dbAddress='" + dbAddress + '\'' +
                ", dbUsername='" + dbUsername + '\'' +
                ", dbPassword='" + dbPassword + '\'' +
                ", dbPort=" + dbPort +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", hash='" + hash + '\'' +
                '}';
    }
}
