package Models;
import java.io.*;
import java.util.Scanner;
/**
 * Created by Paul on 31/03/2017.
 */
public class UnitSer{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        Unit u = new Unit();
        System.out.println("Input unit name:");
        u.u_name = scan.next();
        System.out.println("Input unit Recruitment Cost:");
        u.u_RCost = scan.nextInt();
        System.out.println("Input unit Upkeep cost:");
        u.u_UCost = scan.nextInt();
        System.out.println("Input unit type(0 for land 1 for navy:");
        u.u_type = scan.nextInt();
        SerUnits(u);
    }

    static void SerUnits(Unit u){
        try {
            FileOutputStream fOut = new FileOutputStream("./Resource/unit/" + u.u_name +".ser");
            ObjectOutputStream out = new ObjectOutputStream(fOut);
            out.writeObject(u);
            out.close();
            fOut.close();
        } catch(IOException i) {
            i.printStackTrace();
        }
    }
}
