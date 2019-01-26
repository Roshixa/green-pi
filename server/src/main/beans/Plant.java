package main.beans;

public class Plant {
    private Integer id;
    private Integer userId;
    private String name;
    private String address;
    private String description;

    public Plant(Integer id, Integer userId, String name, String address, String description) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.address = address;
        this.description = description;
    }

    public Plant() {
    }

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "id=" + id +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
