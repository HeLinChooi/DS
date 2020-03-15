package Tuto2;
//He Lin's code
import java.util.Random;

public class Q4ArrayDice implements Q4Dice {

    private Integer[] arr;
    public void roll(int times) {
        System.out.println("Array Implementation: Roll " + times + " time{s)");
        arr = new Integer[times];
        Random r = new Random();
        for (int i = 0; i < times; i++) {
            arr[i] = r.nextInt(6) + 1;
        }
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            s.append(arr[i] + " ");
            total += arr[i];
        }
        s.append("\nTotal is " + total);
        return new String(s);
    }
}
