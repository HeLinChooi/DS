package Lab9;
//He Lin's code

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        try {
            Scanner s = new Scanner(new FileInputStream("lab9Q4.txt"));
            Q4ArrayHashTable<Integer,String> ht = new Q4ArrayHashTable<>();
            System.out.println("Data from file.");
            while(s.hasNextLine()){
                String str = s.nextLine();
                System.out.println(str);
                ht.put(Integer.valueOf(str.substring(0, 5)), str.substring(5));
            }
//            ht.showHashTable();
            if(ht.containsKey(10544)){
                System.out.println("Product ID : " + ht.get(10544));
            }else{
                System.out.println("Product ID 10544 cannot be found.");
            }
            if(ht.containsKey(10863)){
                System.out.println("Product ID : " + ht.get(10863));
                System.out.println("Location:" + ht.getLocation(10863));
            }else{
                System.out.println("Product ID 10863 cannot be found.");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException");
        }
    }
}
