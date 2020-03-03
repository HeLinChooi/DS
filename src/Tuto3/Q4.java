package Tuto3;

import java.util.Scanner;

public class Q4 {
//how to know this is checked or unchecked exception?
    public static void main(String[] args) {
        try{
            Scanner s = new Scanner(System.in);
            String input = s.nextLine();
            if(input.length()>12){
                throw new Q4LongStringException("String length"
                        + " Longer than 12");
            }
        }catch(Q4LongStringException ex){
            System.out.println(ex.getMessage());
        }
    }
}
