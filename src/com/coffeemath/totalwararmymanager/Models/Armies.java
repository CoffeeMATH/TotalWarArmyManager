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
                String aName = army.getNString("ARMY_NAME");
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

}
