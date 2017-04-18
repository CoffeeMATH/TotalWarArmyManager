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
    int playerID;

    public Games(int pID){
        this.playerID = pID;
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
                game.close();
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
           // ResultSet rs = stmt.executeQuery("SELECT * FROM GAMES WHERE GAME_NAME =" + gname +";" );
           /* if(!rs.wasNull())
                return false; */
            String sql = "INSERT INTO GAMES (GAME_NAME, FACTION_ID)" + "VALUES ('" + gname + "' ,1);";

            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery( "SELECT * FROM GAMES WHERE GAME_NAME ='" + gname +"';" );
            int id = 0;

            if(rs.next())
                id = rs.getInt("GAME_ID");
            Game temp = new Game(gname, id);

            String sql1 = "INSERT INTO PLAYER_GAME (P_ID, G_ID)" + "VALUES (" + this.playerID +","+ id +");";
            stmt.executeUpdate(sql1);
            GameList.add(temp);
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

    public void deleteGame(int index){
        int army_count = GameList.get(index).g_armies.ArmyList.size();
        for (int i = 0; i < army_count; i++){
            GameList.get(index).g_armies.deleteArmy(i);
        }

        int gid = GameList.get(index).g_id;
        GameList.remove(index);
        try{
            Connection c = null;
            Statement stmt = null;
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:TWAMDatabase.db");
            c.setAutoCommit(false);
            String sql = "DELETE FROM PLAYER_GAME WHERE G_ID = " + gid + ";";
            stmt=c.createStatement();
            sql = "DELETE FROM GAMES WHERE GAME_ID = " + gid + ";";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();

        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

    }
    public boolean updateGame(int gameList_index, String newGameName){
        try{
            Connection c = null;
            Statement stmt = null;
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:TWAMDatabase.db");
            c.setAutoCommit(false);

            stmt=c.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM GAMES WHERE GAME_NAME =" + gnameN +";" );
//            if(!rs.wasNull()) return false;
            String oldGameName = GameList.get(gameList_index).getName();
            String sql = "UPDATE GAMES set GAME_NAME ='" +newGameName +"' WHERE GAME_NAME LIKE '" +oldGameName+ "';";
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
