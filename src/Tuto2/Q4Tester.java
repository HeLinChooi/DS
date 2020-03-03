package Tuto2;

public class Q4Tester {
    public static void main(String[] args) {
        Q4ArrayDice a = new Q4ArrayDice();
        Q4LinkedList b = new Q4LinkedList();
        a.roll(7);
        System.out.println(a.toString());
        b.roll(3);
        System.out.println(b.toString());
    }
}
