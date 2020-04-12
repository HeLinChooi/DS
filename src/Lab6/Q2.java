package Lab6;
//He Lin's code

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2 {
    //somehow the sequences of product lines change...why?
    public static void main(String[] args) {
        try {
            Scanner s = new Scanner(new FileInputStream("lab6Q2.txt"));
            Queue<String> codes = new LinkedList<>();
            HashMap<String, Queue<String>> products = new HashMap<>();
            while (s.hasNext()) {
                String temp = s.next();
                if (!codes.contains(temp)) {
                    codes.add(temp);
                    //make a Queue
                    Queue<String> productLine = new LinkedList<>();
                    productLine.add(s.next());
                    products.put(temp, productLine);
                } else {
                    products.get(temp).add(s.next());
                }
            }
            //start displaying
            System.out.print("Product Code in Queue : ");
            while(!codes.isEmpty()){
                System.out.print(codes.remove() + " --> ");
            }
            System.out.println("\nList of product by categories");
            for (String code : products.keySet()) {
                System.out.println("Product : " + code);
                //interesting syntax
                products.get(code).forEach((string) -> {
                    System.out.print(string + " --> ");
                });
                System.out.println("");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Not found");
        }
    }
}
