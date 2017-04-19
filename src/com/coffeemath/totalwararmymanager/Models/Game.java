package com.coffeemath.totalwararmymanager.Models;

public class Game{
    public String g_name;
    public Game game;
    public int g_id;
    public int g_fact;

    public Game(String gname, int gID, int gfact){

        game = this;
        this.g_name = gname;
        this.g_id = gID;
        this.g_fact = gfact;

        g_armies = new Armies(gID, gfact);

    }
    public String getName(){return this.g_name;}
    public Game getGame(){return this;}
    public Armies g_armies;
}