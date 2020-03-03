package Lab1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Q5 {

    public static void main(String[] args) {
        try {
            PrintWriter wr = new PrintWriter(new FileOutputStream("sample.txt"));
            wr.print("I want to eat.");
            wr.close();
            Scanner s = new Scanner(new FileInputStream("sample.txt"));
            String str = s.nextLine();
            System.out.println("The line from the file : " + str);
            s.close();
            ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream("binary.dat"));
            obj.writeUTF("So let's buy some lunch.");
            obj.close();
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("binary.dat"));
            String str2 = in.readUTF();
            System.out.println("Line from binary file: " + str2);
            in.close();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
            System.out.println("Error");

        }

    }
}
