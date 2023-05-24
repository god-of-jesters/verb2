package com.example.verb2.RecycleView;

public class ItemLeader {
    String name;
    String score;
    String place;
    int image;

    public ItemLeader(String name, String score, String place, int image) {
        this.name = name;
        this.score = score;
        this.place = place;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String name) {
        this.place = place;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
