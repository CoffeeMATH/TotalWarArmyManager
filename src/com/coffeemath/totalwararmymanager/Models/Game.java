package com.coffeemath.totalwararmymanager.Models;

public class   Game{
    public String g_name;
    public Game game;
    private int g_id;
    public static Faction g_fact;
    public Game(String name){
        game = this;
        this.g_name = name;
    }
    public String getName(){return this.g_name;}
    public Game getGame(){return this;}
    public Armies g_armies;
}