package com.example.demo;

public class User {

    private int id;
    private String name;
    private String password;
    private String profession;

    public User(int id, String name, String password, String profession) {
        super();
        this.id = id;
        this.name = name;
        this.password = password;
        this.profession = profession;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getProfession() {
        return profession;
    }
    public void setProfession(String profession) {
        this.profession = profession;
    }

}