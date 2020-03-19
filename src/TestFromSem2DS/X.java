package TestFromSem2DS;

import java.util.LinkedList;

public class X {
   public static void main(String[] args) {
       int b = 7;
       for (int i = 0; i < 10; i++) {
           b = (b-1)%7;
           System.out.println(b);
       }
   }
}