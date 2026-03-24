package com.example.cookieshop.repositories;

import com.example.cookieshop.models.Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CookieRepository {
    /* This is a test-repository */

    public List<Game> getAllGames(){
        return new ArrayList<Game>(
            Arrays.asList(
                    new Game(1,"League Of Legends", 1, "Trash"),
                    new Game(2,"Dota 2", 10000, "GOAT"),
                    new Game(3,"Pacman", 20, "OK"),
                    new Game(4,"CS:GO", 50, "OK")
            )
        );
    }

    public Game getCookieById(int id){
        Game gameToReturn = null;
        switch(id){
            case 1 :
                gameToReturn = new Game(1,"League Of Legends", 1, "Trash");
                break;
            case 2 :
                gameToReturn = new Game(2,"Dota 2", 10000, "GOAT");
                break;
            case 3 :
                gameToReturn = new Game(3,"Pacman", 20, "OK");
                break;
            case 4 :
                gameToReturn = new Game(4,"CS:GO", 50, "OK");
                break;
        }
        return gameToReturn;
    }
}
