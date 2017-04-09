package com.coffeemath.totalwararmymanager.Controller.TestModels;

import javafx.collections.ObservableList;

/**
 * Created by Alcoseba on 4/4/2017.
 */
public class Player{
    private String name;
    private Player player;
    private ObservableList<Game> games;
    public Player(String name){
        player = this;
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public Player getPlayer(){return this; }
    public ObservableList<Game> getGames() {
        return games;
    }
}
