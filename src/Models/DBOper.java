package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Created by L-LHora on 4/1/2017.
 */
public class DBOper {

    public static void main(String args[]){
        insUnit();
    }
    public static void insUnit(){
        Scanner scan = new Scanner(System.in);
        Connection c;
        Statement stmt;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:TWAMDatabase.db");

            c.setAutoCommit(false);
            stmt = c.createStatement();

            String sql;
            String name;
            int factID, UC, RC, ttype, i = 1;
            String yesorno = "y";
            while (yesorno.equals("y")) {
                System.out.println("Unit Name:");
                name = scan.next();
                System.out.println("Faction ID (0 Rome, 1 Carthage, 2 Macedon:");
                factID = scan.nextInt();
                System.out.println("Upkeep Cost:");
                UC = scan.nextInt();
                System.out.println("Recruitment Cost:");
                RC = scan.nextInt();
                System.out.println("Terrain Type(0 for land, 1 for sea):");
                ttype = scan.nextInt();
                sql = "INSERT INTO UNIT (UNIT_ID, UNIT_NAME, FACTION_ID, UPKEEP_COST, RECRUITMENT_COST, T_TYPE)" +
                        "VALUES (" + i  + ",'" + name + "'," + factID + "," + UC + "," + RC + "," + ttype + ");";

                stmt.executeUpdate(sql);

                System.out.println("Add another Unit?(y/n)");
                yesorno = scan.next();
                i++;
            }
            stmt.close();
            c.commit();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
}
