package com.coffeemath.totalwararmymanager.Models;

import java.util.ArrayList;

public class Player{
    public String p_name;
    public Player player;
    private int p_id;
    public Player(String name){
        player = this;
        this.p_name = name;
    }
    public String getName(){return this.p_name;}
    public Player getPlayer(){return this;}
    public int getId(){return p_id;}
    public Games p_games;
}