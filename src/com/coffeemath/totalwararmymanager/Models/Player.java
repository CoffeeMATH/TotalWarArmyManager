package com.coffeemath.totalwararmymanager.Models;

import java.util.ArrayList;

public class Player{
    public String p_name;
    public Player player;
    private int p_id;
    public Player(String pname, int pID){

        player = this;
        this.p_name = pname;
        this.p_id = pID;

        p_games = new Games(pID);
    }
    public String getName(){return this.p_name;}
    public Player getPlayer(){return this;}
    public int getId(){return p_id;}
    public Games p_games;
}