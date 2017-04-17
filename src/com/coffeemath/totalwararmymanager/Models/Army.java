package com.coffeemath.totalwararmymanager.Models;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by L-LHora on 4/7/2017.
 */
public class Army {
    public String a_name;
    public Army army;
    public int a_id;
    public ArrayList<Unit> a_units = new ArrayList<>();

    private Connection c;
    private Statement stmt;
    public Army(String aname, int aID){
        army = this;
        this.a_name = aname;
        this.a_id = aID;
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:TWAMDatabase.db");
            c.setAutoCommit(false);

            stmt = c.createStatement();

            String sql = "SELECT * FROM RECRUITMENT WHERE A_ID = " + aID + ";";
            ResultSet rset = stmt.executeQuery(sql);

            while(rset.next()) {

                int uID = rset.getInt("U_ID");
                ResultSet unit = stmt.executeQuery("SELECT * FROM UNIT WHERE UNIT_ID = " + uID + ";");
                Unit temp = new Unit(unit.getString("UNIT_NAME"), unit.getInt("RECRUITMENT_COST"), unit.getInt("UPKEEP_COST"), unit.getInt("T_TYPE"));

                a_units.add(temp);
                unit.close();
                //System.out.println("hahahhaa");
            }
            rset.close();
            stmt.close();
            c.close();

        } catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

    }
    public String getName(){return this.a_name;}
    public Army getArmy(){return this;}

}
