package com.coffeemath.totalwararmymanager.Models;

import java.sql.*;
/**
 * Created by Paul on 31/03/2017.
 */
public class Unit {
    public String u_name;
    public Unit unit;
    public int u_RCost;
    public int u_UCost;
    public int u_type;

    public Unit(String uname, int rcost, int ucost, int utype){
        unit = this;
        this.u_name = uname;
        this.u_RCost = rcost;
        this.u_UCost = ucost;
        this.u_type = utype;
    }

    public String getName(){return this.u_name;}
    public Unit getUnit(){return this;}

}