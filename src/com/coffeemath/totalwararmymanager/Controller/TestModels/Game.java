package com.coffeemath.totalwararmymanager.Controller.TestModels;

/**
 * Created by Alcoseba on 4/6/2017.
 */
public class Game {
    private String name;
    private Game game;
    public Game(String name){
        this.name = name;
        game = this;
    }
    public String getName() {
        return name;
    }
    public Game getGame() {
        return game;
    }
}
