package com.coffeemath.totalwararmymanager.Controller.TestModels;

/**
 * Created by Alcoseba on 4/4/2017.
 */
public class Player{
    private String name;
    private Player player;
    public Player(String name){
        player = this;
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public Player getPlayer(){return this; }
}
