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
    private Statement stmt1;
    private Statement stmt2;
    int gameID;

    public Armies(int gID){
        this.gameID = gID;
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:TWAMDatabase.db");
            //c.setAutoCommit(false);

            stmt1 = c.createStatement();

            String sql = "SELECT * FROM GAME_ARMY WHERE G_ID = " + gID ;
            ResultSet rset = stmt1.executeQuery(sql);

            while (rset.next()){
                stmt2 = c.createStatement();
                int aID = rset.getInt("A_ID");
                sql = "SELECT * FROM ARMY WHERE ARMY_ID = " + aID;
                ResultSet army = stmt2.executeQuery(sql);
                army.next();
                String aName = army.getString("ARMY_NAME");
                Army temp = new Army(aName, aID);
                ArmyList.add(temp);
                army.close();
                stmt2.close();
            }
            rset.close();
            stmt1.close();
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
            String sql = "INSERT INTO ARMY (ARMY_NAME, TERRAIN_TYPE)" + " VALUES ('"+ army_name + "' , 1);";
            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery( "SELECT * FROM ARMY WHERE ARMY_NAME LIKE '" + army_name +"';" );
            int id = 0;
            if(rs.next())
                id = rs.getInt("ARMY_ID");
            Army temp = new Army(army_name, id);
            String sql1 = "INSERT INTO GAME_ARMY (G_ID, A_ID)" + "VALUES (" + gameID +","+ id +");";
            stmt.executeUpdate(sql1);
            ArmyList.add(temp);
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

    public void deleteArmy(int index){
        int aid = ArmyList.get(index).a_id;
        ArmyList.remove(index);

        try {
            Connection c = null;
            Statement stmt = null;
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:TWAMDatabase.db");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String  sql = "DELETE FROM RECRUITMENT WHERE A_ID = " + aid +";" ;
            stmt.executeUpdate(sql);

            sql = "DELETE FROM GAME_ARMY WHERE A_ID = " + aid +";" ;
            stmt.executeUpdate(sql);

            sql = "DELETE FROM ARMY WHERE ARMY_ID = " + aid +";" ;
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        }catch (Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    public boolean updateArmy(int armyList_index, String newArmyName){
        try {
            Connection c = null;
            Statement stmt = null;
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:TWAMDatabase.db");
            c.setAutoCommit(false);

            stmt = c.createStatement();
//          ResultSet rs = stmt.executeQuery("SELECT  * FROM ARMY WHERE ARMY_NAME = "+ army_name + ";");
//          if(rs.wasNull()) return false;
            String oldArmyName = ArmyList.get(armyList_index).getName();
            String sql = "UPDATE ARMY SET ARMY_NAME = '" + newArmyName +"' WHERE ARMY_NAME LIKE '"+ oldArmyName +"';";
            stmt.executeUpdate(sql);
            ArmyList.get(armyList_index).a_name = newArmyName;

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