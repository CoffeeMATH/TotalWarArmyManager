package com.coffeemath.totalwararmymanager.Models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by L-LHora on 4/7/2017.
 */
public class Army {
    public String a_name;
    public Army army;
    public int a_id;
    public int terrain_type;
    public int faction;
    public ObservableList<Unit> a_units = FXCollections.observableArrayList();
    public int a_size = 0;
    private int totalUC =0;
    private int totalRC = 0;
    private Connection c;
    private Statement stmt1;
    private Statement stmt2;
    public Army(String aname, int aID, int fact, int ttype){
        army = this;
        this.a_name = aname;
        this.a_id = aID;
        this.faction = fact;
        this.terrain_type = ttype;
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:TWAMDatabase.db");
            c.setAutoCommit(false);

            stmt1 = c.createStatement();

            String sql = "SELECT * FROM RECRUITMENT WHERE A_ID = " + aID + ";";
            ResultSet rset = stmt1.executeQuery(sql);

            while(rset.next()) {
                stmt2 = c.createStatement();
                int uID = rset.getInt("U_ID");
                ResultSet unit = stmt2.executeQuery("SELECT * FROM UNIT WHERE UNIT_ID = " + uID + ";");
                Unit temp = new Unit(uID, unit.getString("UNIT_NAME"), unit.getInt("RECRUITMENT_COST"), unit.getInt("UPKEEP_COST"), unit.getInt("T_TYPE"));
                totalRC += temp.u_RCost;
                totalUC += temp.u_UCost;
                a_units.add(temp);
                unit.close();
                stmt2.close();

            }
            rset.close();
            stmt1.close();
            c.close();

        } catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

    }
    public String getName(){return this.a_name;}
    public Army getArmy(){return this;}



    public boolean addUnit(String unit_name){
        if (a_size > 19){
            return false;
        }
        else {
            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:TWAMDatabase.db");
                c.setAutoCommit(false);

                stmt1 = c.createStatement();



                String sql = "SELECT * FROM UNIT WHERE UNIT_NAME = '" + unit_name + "';";
                ResultSet unit = stmt1.executeQuery(sql);
                Unit temp = new Unit(unit.getInt("UNIT_ID"), unit.getString("UNIT_NAME"), unit.getInt("RECRUITMENT_COST"), unit.getInt("UPKEEP_COST"), unit.getInt("T_TYPE"));

                sql = "INSERT INTO RECRUITMENT(A_ID, U_ID) VALUES (" + this.a_id + "," + temp.u_ID + ");";
                stmt1.executeUpdate(sql);

                totalRC += temp.u_RCost;
                totalUC += temp.u_UCost;
                a_units.add(temp);
                a_size++;
                unit.close();
                stmt1.close();
                c.commit();
                c.close();


            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
        }

        return true;
    }

    public boolean deleteUnit(int index){
        if (index < 0 || index > a_size){
            return false;
        }
        else {
            int uID = a_units.get(index).u_ID;
            a_units.remove(index);
            a_size--;
            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:TWAMDatabase.db");
                c.setAutoCommit(false);

                stmt1 = c.createStatement();

                ResultSet rs = stmt1.executeQuery("SELECT * FROM UNIT WHERE UNIT_ID = " + uID + ";");
                rs.next();
                totalRC -= rs.getInt("RECRUITMENT_COST");
                totalUC -= rs.getInt("UPKEEP_COST");

                rs = stmt1.executeQuery("SELECT ROWID, * FROM RECRUITMENT WHERE A_ID = " + a_id + " AND U_ID = " + uID + ";");
                rs.next();
                int rowID = rs.getInt("ROWID");
                stmt1.executeUpdate("DELETE FROM RECRUITMENT WHERE ROWID = " + rowID + ";");

                rs.close();
                stmt1.close();
                c.commit();
                c.close();

            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
        }
        return true;
    }

    public ObservableList<Unit> showUnit(){
        ObservableList<Unit> unitList = FXCollections.observableArrayList();
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:TWAMDatabase.db");
            c.setAutoCommit(false);
            stmt1 = c.createStatement();

            String sql = "SELECT * FROM UNIT WHERE FACTION_ID = " + this.faction  + " AND T_TYPE =" + this.terrain_type +";";
            ResultSet rs =  stmt1.executeQuery(sql);

            while(rs.next()){
                int uID = rs.getInt("UNIT_ID");
                String uName = rs.getString("UNIT_NAME");
                int uc = rs.getInt("UPKEEP_COST");
                int rc = rs.getInt("RECRUITMENT_COST");
                Unit temp = new Unit(uID, uName, uc, rc, this.terrain_type);
                unitList.add(temp);
            }

            rs.close();
            stmt1.close();
            c.close();

        }catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return unitList;
    }

    public int getTotalUC() {
        return totalUC;
    }

    public int getTotalRC() {
        return totalRC;
    }
}
