package com.coffeemath.totalwararmymanager.Models;

/**
 * Created by John Michael on 4/17/2017.
 */
public class Test {
    public static void main(String[] args){
        Players player = new Players();
        System.out.println(player.PlayerList.get(0).getId());
        System.out.println(player.PlayerList.get(0).getName());
    }

}
