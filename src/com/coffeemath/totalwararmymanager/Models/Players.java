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

    public Players(){

        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:TWAMDatabase.db");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            ResultSet pset = stmt.executeQuery("SELECT * FROM PLAYERS");
            while ( pset.next() ){
                Player temp = new Player();
                temp.p_id = pset.getInt("PLAYER_ID");
                temp.p_name = pset.getString("PLAYER_NAME");
                PlayerList.add(temp);
            }
            pset.close();
            stmt.close();
            c.close();
        } catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
    public boolean addPlayer(String pname){
        try{
            Connection c = null;
            Statement stmt  = null;
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:TWAMDatabase.db");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM PLAYERS WHERE PLAYER_NAME =" + pname +";" );
            if(!rs.wasNull()){
                return false;
            }
            String sql = "INSERT INTO PLAYERS (PLAYER_NAME)" + "VALUES (" + pname + ");";
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
    public void deletePlayer(String pname){
        try{
            Connection c = null;
            Statement stmt  = null;
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:TWAMDatabase.db");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "DELETE from COMPANY where PLAYER_NAME =" + pname + ";";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();


        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

    }

    public boolean updatePlayer(String pnameO, String pnameN){
        try{
            Connection c = null;
            Statement stmt  = null;
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:TWAMDatabase.db");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM PLAYERS WHERE PLAYER_NAME =" + pnameN +";" );
            if(!rs.wasNull())return false;
            else {
                String sql = "UPDATE PLAYERS set PLAYER_NAME =" + pnameN + "WHERE PLAYER_NAME =" + pnameO + ";";
            }
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();
            return true;
        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
}
