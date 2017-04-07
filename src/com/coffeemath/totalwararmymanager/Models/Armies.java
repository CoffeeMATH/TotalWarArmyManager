package com.coffeemath.totalwararmymanager.Models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

/**
 * Created by Paul on 31/03/2017.
 */
public class Armies {
    public static ObservableList<Army> ArmyList= FXCollections.observableArrayList();
    private Connection c;
    private Statement stmt;
/*
    public Armies(){
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:TWAMDatabase.db");
            c.setAutoCommit(false);



        }
    }
    */
}
