package com.example.verb2.DB;

public class User {
    private int id;
    private String name;
    private String password;
    private int score;

    public User(int id, String name, String password, int score) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.score = score;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score){
        this.score = score;
    }
}
