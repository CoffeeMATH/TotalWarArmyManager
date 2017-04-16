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
                sql = "SELECT * FROM GAMES WHERE GAME_ID = " + gID;
                ResultSet game = stmt.executeQuery(sql);
                String gName = game.getString("GAME_NAME");
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
    public boolean addGame(String gname){
        try{
            Connection c = null;
            Statement stmt = null;
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:TWAMDatabase.db");
            c.setAutoCommit(false);

            stmt=c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM GAMES WHERE GAME_NAME =" + gname +";" );
            if(!rs.wasNull())
                return false;
            String sql = "INSERT INTO GAMES (GAME_NAME)" + "VALUES (" + gname + ");";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
            return true;


        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return false;
    }

    public void deleteGame(String gname){
        try{
            Connection c = null;
            Statement stmt = null;
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:TWAMDatabase.db");
            c.setAutoCommit(false);

            stmt=c.createStatement();
            String sql = "DELETE FROM GAMES WHERE GAME_NAME = " +  gname + ";";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();

        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

    }
    public boolean updateGame(String gnameO, String gnameN){
        try{
            Connection c = null;
            Statement stmt = null;
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:TWAMDatabase.db");
            c.setAutoCommit(false);

            stmt=c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM GAMES WHERE GAME_NAME =" + gnameN +";" );
            if(!rs.wasNull())
                return false;
            String sql = "UPDATE GAMES set GAME_NAME =" +gnameN +"WHERE GAME_NAME =" +gnameO+ ";";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
            return true;


        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return false;
    }

}
