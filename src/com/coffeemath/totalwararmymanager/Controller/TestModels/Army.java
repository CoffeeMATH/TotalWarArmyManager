package com.coffeemath.totalwararmymanager.Controller.TestModels;

/**
 * Created by Alcoseba on 4/13/2017.
 */
public class Army {
    private String name;
    private String genName;
    private Army army;
    private String type;
    public Army(String name, String gen, String type){
        this.name = name;
        this.genName = gen;
        this.type = type;
        army = this;
    }

    public String getGenName() {
        return genName;
    }

    public String getType() {
        return type;
    }

    public void setGenName(String genName) {
        this.genName = genName;
    }

    public String getName() {
        return name;
    }

    public Army getArmy() {
        return army;
    }

    public void setName(String name) {
        this.name = name;
    }
}
