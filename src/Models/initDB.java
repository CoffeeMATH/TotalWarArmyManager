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
                    "(PLAYER_ID   INT PRIMARY KEY NOT NULL," +
                    " PLAYER_NAME  TEXT            NOT NULL)";
            stmt.executeUpdate(sql);
            sql =  "CREATE TABLE GAMES" +
                    "(GAME_ID     INT PRIMARY KEY NOT NULL," +
                    " GAME_NAME   TEXT            NOT NULL)";
            stmt.executeUpdate(sql);
            sql = "CREATE TABLE PLAYER_GAME" +
                    "(P_ID        INT," +
                    " G_ID        INT," +
                    " FOREIGN KEY(P_ID) REFERENCES PLAYERS(PLAYER_ID)," +
                    " FOREIGN KEY(G_ID) REFERENCES GAMES(GAME_ID))";
            stmt.executeUpdate(sql);
            sql = "CREATE TABLE ARMY" +
                    "(ARMY_ID     INT," +
                    " ARMY_NAME   TEXT," +
                    " TYPE        INT)"; //0 for Land army and 1 for Navy
            stmt.executeUpdate(sql);
            sql = "CREATE TABLE GAME_ARMY" +
                    "(G_ID        INT," +
                    " A_ID        INT," +
                    " FOREIGN KEY(G_ID) REFERENCES GAMES(GAME_ID)," +
                    " FOREIGN KEY(A_ID) REFERENCES ARMY(ARMY_ID))";
            stmt.close();

            c.close();

        }  catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
}
