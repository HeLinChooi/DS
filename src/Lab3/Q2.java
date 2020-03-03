package Lab3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Q2 {
    public static void readLine(Scanner r){
        if(!r.hasNextLine()){
            return;
        }else{
            String line = r.nextLine();
            readLine(r);
            System.out.println(line);
        }
    }
    public static void main(String[] args) {
        try {
            PrintWriter p = new PrintWriter(new FileOutputStream("samp.txt"));
            p.println("I am He Lin.");
            p.println("Now is sem 2.");
            p.println("Then I only know java.");
            p.close();
            Scanner r = new Scanner(new FileInputStream("samp.txt"));
            readLine(r);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        
    }
}
