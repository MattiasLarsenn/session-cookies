package com.example.cookieshop.models;

public class Game {
    private int id;
    private String name;
    private int price;
    private String quality;

    public Game(int id, String name, int price, String quality) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quality = quality;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getQuality(){
        return this.quality;
    }
}
