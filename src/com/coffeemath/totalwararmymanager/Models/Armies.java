package com.coffeemath.totalwararmymanager.Models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

/**
 * Created by Paul on 31/03/2017.
 */
public class Armies {
    public ObservableList<Army> ArmyList= FXCollections.observableArrayList();
    public Army ACursor;
    private Connection c;
    private Statement stmt;

    public Armies(int gID){
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:TWAMDatabase.db");
            //c.setAutoCommit(false);

            stmt = c.createStatement();

            String sql = "SELECT * FROM GAME_ARMY WHERE G_ID = " + gID ;
            ResultSet rset = stmt.executeQuery(sql);

            while (rset.next()){
                int aID = rset.getInt("A_ID");
                sql = "SELECT * FROM ARMY WHERE ARMY_ID = " + aID;
                ResultSet army = stmt.executeQuery(sql);
                army.next();
                String aName = army.getString("ARMY_NAME");
                Army temp = new Army(aName, aID);
                ArmyList.add(temp);
            }

            stmt.close();
            c.close();

        } catch(Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }


    public boolean addArmy(String army_name){

        try {
            Connection c = null;
            Statement stmt = null;
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:TWAMDatabase.db");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "INSERT INTO ARMY (ARMY_NAME)" + " VALUES ("+ army_name + ");";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();


            return true;
        }catch (Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return false;
    }

    public void deleteArmy(String army_name){

        try {
            Connection c = null;
            Statement stmt = null;
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:TWAMDatabase.db");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String  sql = "DELETE from ARMY where ARMY_NAME = " +  army_name +";" ;
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        }catch (Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    public boolean updateArmy(String army_name, String new_army_name){
        try {
            Connection c = null;
            Statement stmt = null;
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:TWAMDatabase.db");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT  * FROM ARMY WHERE ARMY_NAME = "+ army_name + ";");
            if(rs.wasNull()) return false;
            else{
                String sql = "UPDATE ARMY SET ARMY_NAME = " + new_army_name +"WHERE ARMY_NAME = "+ army_name +";";
                stmt.executeUpdate(sql);
            }
            //stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
            return true;
        }catch (Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return false;
    }

}