import java.sql.*;
public class initDB {
    public static void main(String args[]){
        Connection c;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:TWAMDatabase.db");

            System.out.println("Database opened");
            String sql;

        }  catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
}
