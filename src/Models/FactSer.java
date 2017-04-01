package Models;
import java.io.*;
import java.util.Scanner;
/**
 * Created by Paul on 31/03/2017.
 */
public class FactSer{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        Faction f = new Faction();
        System.out.println("Input faction name:");
        f.f_name = scan.next();
        System.out.println("Input faction Recruitment Discount:");
        f.discountR = scan.nextInt();
        System.out.println("Input faction Upkeep Discount:");
        f.discountU = scan.nextInt();

        SerFacts(f);
    }

     static void SerFacts(Faction f){
        try {
            FileOutputStream fOut = new FileOutputStream("./Resource/faction/" + f.f_name + ".ser");
            ObjectOutputStream out = new ObjectOutputStream(fOut);
            out.writeObject(f);
            out.close();
            fOut.close();
        } catch(IOException i) {
            i.printStackTrace();
        }
    }
}
