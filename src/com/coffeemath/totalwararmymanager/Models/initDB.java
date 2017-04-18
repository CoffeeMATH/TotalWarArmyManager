package com.coffeemath.totalwararmymanager.Models;

import java.sql.*;
public class initDB {
    public static void main(String args[]){
        Connection c;
        Statement stmt;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:TWAMDatabase.db");
            c.setAutoCommit(false);
            System.out.println("Database opened");
            String sql;

            stmt = c.createStatement();

            sql = "CREATE TABLE PLAYERS" +
                    "(PLAYER_ID   INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "PLAYER_NAME  TEXT            NOT NULL)";
            stmt.executeUpdate(sql);
            sql = "CREATE TABLE GAMES" +
                    "(GAME_ID     INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " GAME_NAME      NUMERIC NOT NULL," +
                    " FACTION_ID     INT NOT NULL);";

            stmt.executeUpdate(sql);
            sql = "CREATE TABLE PLAYER_GAME" +
                    "(P_ID         INTEGER," +
                    " G_ID         INTEGER," +
                    " FOREIGN KEY(P_ID) REFERENCES PLAYERS(PLAYER_ID)," +
                    " FOREIGN KEY(G_ID) REFERENCES GAMES(GAME_ID))";
            stmt.executeUpdate(sql);

            sql = "CREATE TABLE ARMY" +
                    "(ARMY_ID        INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " ARMY_NAME      NUMERIC NOT NULL," +
                    " TERRAIN_TYPE   INTEGER NOT NULL);";

            stmt.executeUpdate(sql);

            sql = "CREATE TABLE GAME_ARMY" +
                    "(G_ID        INTEGER," +
                    " A_ID        INTEGER," +
                    " FOREIGN KEY(G_ID) REFERENCES GAMES(GAME_ID)," +
                    " FOREIGN KEY(A_ID) REFERENCES ARMY(ARMY_ID))";

            stmt.executeUpdate(sql);

            sql = "CREATE TABLE ARMY_LEADER" +
                    "(LEADER_ID        INTEGER PRIMARY KEY," +
                    " LEADER_NAME      NUMERIC NOT NULL," +
                    " RECRUITMENT_DISCOUNT INT NOT NULL," +
                    " UPKEEP_DISCOUNT  INTEGER NOT NULL," +
                    " T_TYPE           INTEGER NOT NULL)";

            stmt.executeUpdate(sql);

            sql = "CREATE TABLE LEADER_ASSIGNMENT" +
                    "(L_ID         INTEGER," +
                    " A_ID         INTEGER," +
                    " FOREIGN KEY(L_ID) REFERENCES ARMY_LEADER(LEADER_ID)," +
                    " FOREIGN KEY(A_ID) REFERENCES ARMY(ARMY_ID))";

            stmt.executeUpdate(sql);

            sql = "CREATE TABLE UNIT" +
                    "(UNIT_ID           INT PRIMARY KEY," +
                    " UNIT_NAME         NUMERIC NOT NULL," +
                    " FACTION_ID        INT NOT NULL," +
                    " UPKEEP_COST       INT NOT NULL," +
                    " RECRUITMENT_COST  INT NOT NULL," +
                    " T_TYPE            INT NOT NULL)";

            stmt.executeUpdate(sql);

            sql = "CREATE TABLE RECRUITMENT" +
                    "(A_ID              INTEGER," +
                    " U_ID              INT," +
                    " FOREIGN KEY (A_ID) REFERENCES ARMY(ARMY_ID)" +
                    " FOREIGN KEY (U_ID) REFERENCES UNIT(UNIT_ID))";

            stmt.executeUpdate(sql);



            stmt.close();
            c.commit();
            c.close();

        }  catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
}
