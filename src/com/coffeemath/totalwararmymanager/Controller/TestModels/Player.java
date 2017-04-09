package com.coffeemath.totalwararmymanager.Controller.TestModels;

import javafx.collections.ObservableList;

/**
 * Created by Alcoseba on 4/4/2017.
 */
public class Player{
    private String name;
    private Player player;
    private Scroll<Game> games;
    public Player(String name){
        player = this;
        games = new Scroll<>();
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public Player getPlayer(){return this; }
    public Scroll<Game> getGames() {
        return games;
    }
}
