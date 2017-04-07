package com.coffeemath.totalwararmymanager.Models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

/**
 * Created by Paul on 31/03/2017.
 */
public class Players {
    public static ObservableList<Player> PlayerList = FXCollections.observableArrayList();
    public Player PCursor;
    private Connection c;
    private Statement stmt;

   // public Players{
/*
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:TWAMDatabase.db");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            ResultSet pset = stmt.executeQuery("SELECT * FROM PLAYERS");

        }
    }
    public void addPlayer{}
*/
}
