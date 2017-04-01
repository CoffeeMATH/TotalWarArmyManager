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
                    "PLAYER_NAME  TEXT            NOT NULL)";
            stmt.executeUpdate(sql);
            sql =  "CREATE TABLE GAMES" +
                    "(GAME_ID     INT PRIMARY KEY NOT NULL," +
                    "GAME_NAME    TEXT            NOT NULL)";
            stmt.executeUpdate(sql);
            sql = "CREATE TABLE PLAYER_GAME" +
                    "(P_ID        INT," +
                    " G_ID         INT," +
                    " FOREIGN KEY(P_ID) REFERENCES PLAYERS(PLAYER_ID)," +
                    " FOREIGN KEY(G_ID) REFERENCES GAMES(GAME_ID))";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();

        }  catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
}
