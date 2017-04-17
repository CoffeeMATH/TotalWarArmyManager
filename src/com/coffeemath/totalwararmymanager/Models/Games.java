package com.coffeemath.totalwararmymanager.Models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

/**
 * Created by Paul on 31/03/2017.
 */
public class Games{
    public static ObservableList<Game> GameList = FXCollections.observableArrayList();
    private Connection c;
    private Statement stmt;

    public Games(int pID){
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:TWAMDatabase.db");

            stmt = c.createStatement();

            String sql = "SELECT * FROM PLAYER_GAME WHERE P_ID = " + pID;
            ResultSet rset = stmt.executeQuery(sql);

            while (rset.next()){
                int gID = rset.getInt("G_ID");
                sql = "SELECT * FROM GAMES WHERE G_ID = " + gID;
                ResultSet game = stmt.executeQuery(sql);
                String gName = game.getNString("GAME_NAME");
                Game temp = new Game(gName, gID);
                GameList.add(temp);
            }
            stmt.close();
            c.close();
        } catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
}
