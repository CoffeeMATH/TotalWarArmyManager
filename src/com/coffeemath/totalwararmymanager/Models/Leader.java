package com.coffeemath.totalwararmymanager.Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by John Michael on 4/19/2017.
 */
public class Leader {
    public Leader leader;
    public String leader_name;
    public int leader_id;
    public int terrain_type;
    public int recruitment_discount;
    public int upkeep_discount;

    public Leader(String l_name,int l_id, int t_type, int r_discount, int u_discount ){
        leader = this;
        this.leader_name = l_name;
        this.leader_id = l_id;
        this.terrain_type = t_type;
        this.recruitment_discount = r_discount;
        this.upkeep_discount = u_discount;
    }
    /** Available Functions **/
    public Leader getLeader(){return this;}
    public String getName(){ return this.leader_name;}
    public int getLeader_id(){return this.leader_id;}
    public int getTerrain_type(){return this.terrain_type;}
    public int getRecruitment_discount(){return this.recruitment_discount;}
    public int getUpkeep_discount(){return this.upkeep_discount;}

    /** adding to database **/
    public Leader LCursor;
    private Connection c;
    private Statement stmt;
        try{

            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:TWAMDatabase.db");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            ResultSet leaderSet = stmt.executeQuery("SELECT * FROM ARMY_LEADER");

            while ( leaderSet.next() ){
                String lead_name = leaderSet.getString("LEADER_NAME");
                int lead_id = leaderSet.getInt("LEADER_ID");
                int ter_type = leaderSet.getInt("T_TYPE");
                int r_cost = leaderSet.getInt("RECRUITMENT_DISCOUNT");
                int u_cost = leaderSet.getInt("UPKEEP_DISCOUNT");

                Leader temp = new Leader(lead_name, lead_id, ter_type, r_cost, u_cost);
            }
            pset.close();
            stmt.close();
            c.close();
        } catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

}

