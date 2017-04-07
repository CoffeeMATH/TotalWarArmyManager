package com.coffeemath.totalwararmymanager.Models;

/**
 * Created by L-LHora on 4/7/2017.
 */
public class Army {
    public String a_name;
    public Army army;
    public int a_id;
    public Army(String name){
        army = this;
        this.a_name = name;
    }
    public String getName(){return this.a_name;}
    public Army getArmy(){return this;}
    public Units a_units;

}
