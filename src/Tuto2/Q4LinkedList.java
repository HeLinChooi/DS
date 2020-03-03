package Tuto2;

import java.util.LinkedList;
import java.util.Random;

public class Q4LinkedList implements Q4Dice {

    private LinkedList<Integer> ll;

    public void roll(int times) {
        System.out.println("Linked List Implementation: Roll " + times + " time{s)");
        ll = new LinkedList<>();
        Random r = new Random();
        for (int i = 0; i < times; i++) {
            ll.add(r.nextInt(6) + 1);
        }
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        int total = 0;
        for (int i = 0; i < ll.size(); i++) {
            s.append(ll.get(i) + " ");
            total += ll.get(i);
        }
        s.append("\nTotal is " + total);
        return new String(s);
    }
}
