package com.coffeemath.totalwararmymanager.Controller.TestModels;

/**
 * Created by Alcoseba on 4/6/2017.
 */
public class Game {
    private String name;
    private Game game;
    private Scroll<Army> armies;
    public Game(String name){
        this.name = name;
        armies = new Scroll<>();
        game = this;
    }
    public String getName() {
        return name;
    }
    public Game getGame() {
        return game;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Scroll<Army> getArmies() {
        return armies;
    }
}
