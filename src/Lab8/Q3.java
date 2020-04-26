package Lab8;
//He Lin's code

import java.util.Date;

public class Q3{
    public static void main(String[] args) {
        //I only use 10000 elements for testing purpost.
        //make 10 sets of 100000 elements while you want to take a nap
        Q3SortTest<Integer> a = new Q3SortTest<>(1,1);
        long ini = System.currentTimeMillis();
        a.bubbleSort();
        long last = System.currentTimeMillis();
//        System.out.println(ini + " " + last);
        System.out.println("BubbleSort:" + (last-ini));
        ini = System.currentTimeMillis();
        a.selectionSort();
        last = System.currentTimeMillis();
        System.out.println("selectionSort:" + (last-ini));
        ini = System.currentTimeMillis();
        a.insertionSort();
        last = System.currentTimeMillis();
        System.out.println("insertionSort:" + (last-ini));
        ini = System.currentTimeMillis();
        a.mergeSort();
        last = System.currentTimeMillis();
        System.out.println("mergeSort:" + (last-ini));
        ini = System.currentTimeMillis();
        a.quickSort();
        last = System.currentTimeMillis();
        System.out.println("quickSort:" + (last-ini));
    }
}
