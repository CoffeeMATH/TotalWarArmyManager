package com.coffeemath.totalwararmymanager.Models;

/**
 * Created by Paul on 31/03/2017.
 */
public class Unit {
    public int u_ID;
    public String u_name;
    public Unit unit;
    public int u_RCost;
    public int u_UCost;
    public int u_type;
    public int u_ct;

    public Unit(int uID, String uname, int rcost, int ucost, int utype){
        unit = this;
        this.u_ID = uID;
        this.u_name = uname;
        this.u_RCost = rcost;
        this.u_UCost = ucost;
        this.u_type = utype;
    }

    public String getName(){return this.u_name;}
    public Unit getUnit(){return this;}

    /**
     * Created by Paul on 31/03/2017.
     */
    public static class toController {

    }
}