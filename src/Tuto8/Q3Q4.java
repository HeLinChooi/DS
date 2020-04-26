package Tuto8;
//He Lin's code

import java.util.Random;

public class Q3Q4 {
    public static void main(String[] args) {
        Q3LinkedList<Integer> a = new Q3LinkedList<>();
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            a.addNode(r.nextInt(101));
        }
        System.out.println("before");
        a.showList();
//        a.selectionSort();
//        System.out.println("after selection sort");
        a.bubbleSort();
        System.out.println("after bubble sort");
        a.showList();
    }
}
