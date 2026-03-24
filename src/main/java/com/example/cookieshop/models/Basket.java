package com.example.cookieshop.models;

import java.util.List;

public class Basket {
    private List<Game> gameList;

    public Basket(List<Game> gameList) {
        this.gameList = gameList;
    }

    public List<Game> getCookieList() {
        return gameList;
    }

    public void setCookieList(List<Game> gameList) {
        this.gameList = gameList;
    }
}
