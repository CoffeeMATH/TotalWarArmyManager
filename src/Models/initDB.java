package Models;

import java.sql.*;
public class initDB {
    public static void main(String args[]){
        Connection c;
        Statement stmt;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:TWAMDatabase.db");

            System.out.println("Database opened");
            String sql;
            stmt = c.createStatement();

            sql = "CREATE TABLE PLAYERS" +
                    "(PLAYER_ID     INT PRIMARY KEY NOT NULL," +
                    " PLAYER_NAME   TEXT            NOT NULL)";
            stmt.executeUpdate(sql);

            sql =  "CREATE TABLE GAMES" +
                    "(GAME_ID     INT PRIMARY KEY NOT NULL," +
                    " GAME_NAME   TEXT            NOT NULL)";
            stmt.executeUpdate(sql);

            sql = "CREATE TABLE PLAYER_GAME" +
                    "(P_ID        INT," + // PLAYER_ID
                    " G_ID        INT," + // GAME_ID
                    " FOREIGN KEY(P_ID) REFERENCES PLAYERS(PLAYER_ID)," +
                    " FOREIGN KEY(G_ID) REFERENCES GAMES(GAME_ID))";
            stmt.executeUpdate(sql);

            sql = "CREATE TABLE ARMY" +
                    "(ARMY_ID          INT PRIMARY KEY NOT NULL," +
                    " ARMY_NAME        TEXT            NOT NULL," +
                    " TERRAIN_TYPE     INT             NOT NULL)"; // 0:LAND, 1:NAVY
            stmt.executeUpdate(sql);

            sql = "CREATE TABLE GAME_ARMY" +
                    "(G_ID        INT," + // GAME_ID
                    " A_ID        INT," + // ARMY_ID
                    " FOREIGN KEY(G_ID) REFERENCES GAMES(GAME_ID)," +
                    " FOREIGN KEY(A_ID) REFERENCES ARMY(ARMY_ID))";
            stmt.executeUpdate(sql);

            sql =  "CREATE TABLE UNIT" +
                    "(UNIT_ID           INT PRIMARY KEY NOT NULL," +
                    " UNIT_NAME         TEXT            NOT NULL," +
                    " FACTION_ID        INT             NOT NULL," + // 0:ROME, 1:CARTAGE, 2:MACEDOM
                    " UPKEEP_COST       INT             NOT NULL," +
                    " RECRUITMENT_COST  INT             NOT NULL," +
                    " T_TYPE            INT             NOT NULL," + // 0:LAND, 1:NAVY
                    " FOREIGN KEY(T_TYPE) REFERENCES ARMY(TERRAIN_TYPE))";
            stmt.executeUpdate(sql);

            sql =  "CREATE TABLE RECRUITMENT" +
                    "(A_ID     INT PRIMARY KEY NOT NULL," +    // ARMY_ID
                    " U_ID     INT             NOT NULL," +    // UNIT_ID
                    " FOREIGN KEY(A_ID) REFERENCES ARMY(ARMY_ID)," +
                    " FOREIGN KEY(U_ID) REFERENCES UNIT(UNIT_ID))";
            stmt.executeUpdate(sql);

            sql =  "CREATE TABLE LEADER_ASSIGNMENT" +
                    "(LEADER_ID     INT PRIMARY KEY NOT NULL," +
                    " A_ID           INT             NOT NULL," + // ARMY_ID
                    " FOREIGN KEY(A_ID) REFERENCES ARMY(ARMY_ID))";
            stmt.executeUpdate(sql);

            sql =  "CREATE TABLE ARMY_LEADER" +
                    "(L_ID                  INT," + // LEADER_ID
                    "LEADER_NAME            TEXT    NOT NULL,"+
                    "RECRUITMENT_DISCOUNT   INT     NOT NULL," +
                    "UPKEEP_DISCOUNT        INT     NOT NULL,"+
                    "L_TYPE                 INT," +
                    " FOREIGN KEY(L_ID) REFERENCES GENERAL_ASSIGNMENT(GENERAL_ID)," +
                    " FOREIGN KEY(L_TYPE) REFERENCES ARMY(TERRAIN_TYPE))" ;
            stmt.executeUpdate(sql);



            stmt.close();

            c.close();

        }  catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
}
