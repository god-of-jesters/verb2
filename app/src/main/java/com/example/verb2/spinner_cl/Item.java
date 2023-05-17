package com.example.verb2.spinner_cl;

public class Item {
    String name;
    String opis;

    public Item(String name, String opis){
        this.name = name;
        this.opis = opis;
    }
    public String getName(){
        return this.name;
    }

    public String getOpis(){
        return this.opis;
    }
}
