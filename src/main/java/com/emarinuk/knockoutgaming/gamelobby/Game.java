package com.emarinuk.knockoutgaming.gamelobby;

/**
 * Created by Eduardo on 19/02/2018
 */
public class Game {

    private String gameName;

    public Game(String name) {
        super();
        this.gameName = name;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }
}
