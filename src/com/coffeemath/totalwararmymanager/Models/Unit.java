package com.coffeemath.totalwararmymanager.Models;

/**
 * Created by Paul on 31/03/2017.
 */
public class Unit {
    public String u_name;
    public Unit unit;
    public int u_RCost;
    public int u_UCost;
    public int u_type;
    public Unit(String name){
        unit = this;
        this.u_name=name;
    }
    public String getName(){return this.u_name;}
    public Unit getUnit(){return this;}

}