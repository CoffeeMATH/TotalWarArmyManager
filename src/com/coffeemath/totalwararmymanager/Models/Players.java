package com.coffeemath.totalwararmymanager.Models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

/**
 * Created by Paul on 31/03/2017.
 */
public class Players {
    public ObservableList<Player> PlayerList = FXCollections.observableArrayList();
    public Player PCursor;
    private Connection c;
    private Statement stmt;
    public int counter;

    public Players(){

        try{

            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:TWAMDatabase.db");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            ResultSet pset = stmt.executeQuery("SELECT * FROM PLAYERS");
            while ( pset.next() ){
                int pID = pset.getInt("PLAYER_ID");
                String pName = pset.getString("PLAYER_NAME");
                Player temp = new Player(pName, pID);
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
            System.out.println("1");

            /*if(!rs.wasNull()){
                System.out.println("here");
                return false;
            }
            else { */

                String sql = "INSERT INTO PLAYERS (PLAYER_NAME)" + "VALUES ('" + pname + "');";


                stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery( "SELECT * FROM PLAYERS WHERE PLAYER_NAME LIKE '" + pname +"';" );
            int id = 0;
            if(rs.next())
                id = rs.getInt("PLAYER_ID");
            Player temp = new Player(pname, id);
            PlayerList.add(temp);
                stmt.close();
                c.commit();
                c.close();
                return true;
           // }

        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return false;
    }
    public void deletePlayer(int index){
        int game_count = PlayerList.get(index).p_games.GameList.size();
        for (int i = 0; i < game_count; i++){
            PlayerList.get(index).p_games.deleteGame(i);
        }
        int pid = PlayerList.get(index).getId();
        PlayerList.remove(index);
        try{
            Connection c = null;
            Statement stmt  = null;
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:TWAMDatabase.db");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "DELETE from PLAYERS where PLAYER_ID =" + pid + ";";
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

            String sql = "UPDATE PLAYERS set PLAYER_NAME =" + pnameN + "WHERE PLAYER_NAME =" + pnameO + ";";

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
