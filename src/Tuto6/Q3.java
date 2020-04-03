package Tuto6;
//He Lin's code

import java.util.Random;

public class Q3 {
    public static void main(String[] args) {
        Random r = new Random();
        Q1Queue<Integer> queue = new Q1Queue<>();
        for (int i = 0; i < 16; i++) {
            queue.enqueue(r.nextInt(3) + 1);
        }
        for (int i = 1; i <= 16; i++) {
            System.out.printf("Customer %d : %d set(s) -->\n",i,queue.dequeue());
        }
    }
}
