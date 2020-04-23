package TestFromSem2DS;

import Lab8.Q2Product;

public class Test1 {
    public static void main(String[] args) {
        Q2Product a = new Q2Product("s", "a", 2, 0);
        Q2Product b = new Q2Product("s", "b", 3, 0);
        Q2Product temp = a;
        a = b;
        b = temp;
        System.out.println(a.getPrice());
        System.out.println(b.getPrice());
    }
}
