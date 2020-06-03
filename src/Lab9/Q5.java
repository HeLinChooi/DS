package Lab9;
//He Lin's code

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {
        try {
            Scanner s = new Scanner(new FileInputStream("lab9Q4.txt"));
            Q5ArrayHashTable<Integer,String> ht = new Q5ArrayHashTable<>();
            System.out.println("Data from file.");
            while(s.hasNextLine()){
                String str = s.nextLine();
                System.out.println(str);
                ht.put(Integer.valueOf(str.substring(0, 5)), str.substring(5));
            }
            ht.showHashTable();
            int test = 10863;
            if(ht.containsKey(test)){
                Q5Node temp = ht.getNode(test);
                System.out.printf("Product ID : %d %s\n",temp.getKey(),temp.getValue());
                System.out.println("The elements in the same location are :");
                ht.getLocation(test);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException");
        }
    }
}
