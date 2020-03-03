package TestFromSem2DS;

import java.util.ArrayList;
//subplement file for GenericsDemo.java
public class X<T> {
   public X(T t) { }
   public T get() { return null; }

   public static int f(String s) { return 1; }
   public static int f(Object o) { return 2; }

   public static void main(String[] args) {
      System.out.println(f(new X<>("").get()));
      System.out.println(f(new X("").get()));
       ArrayList<Integer> a = new ArrayList<>();
   }
}