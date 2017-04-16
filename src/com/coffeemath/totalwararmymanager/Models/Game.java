package com.coffeemath.totalwararmymanager.Models;

public class Game{
    public String g_name;
    public Game game;
    private int g_id;
    public static Faction g_fact;

    public Game(String gname, int gID){
        game = this;
        this.g_name = gname;
        this.g_id = gID;

        g_armies = new Armies(gID);

    }
    public String getName(){return this.g_name;}
    public Game getGame(){return this;}
    public Armies g_armies;
}