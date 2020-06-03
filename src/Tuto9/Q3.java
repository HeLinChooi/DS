package Tuto9;
//He Lin's code

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        System.out.println("Hash Table");
        HashTable<String,String> ht = new HashTable<>();
        ht.put("100-101", "ICND 1");
        ht.put("200-101", "ICND 2");
        ht.put("200-120", "CCNA Routing and Switching");
        ht.put("210-260 ", "CCNA Security");
        System.out.println("THe number of elements in the ht is " + ht.getSize());
        ht.showHashTable();
        System.out.print("\nEnter a code to search:");
        String input = s.nextLine();
        if(ht.containsKey(input)){
            System.out.println("Course " + input + " : " + ht.get(input));
        }else{
            System.out.println("The course " + input + " cannot be found");
        }
    }
}
