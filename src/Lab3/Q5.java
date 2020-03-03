package Lab3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Q5 {

    static Scanner s;
    public static void getInput(int[] inputs) {
        s = new Scanner(System.in);
        try {
            for (int i = index; i < inputs.length; i++) {
            System.out.print("Enter an Integer: ");
            inputs[i] = s.nextInt();
            index++;
        }
        } catch (InputMismatchException ex) {
            System.out.println("Invalid input type");
        }
    }

    static int index = 0;
    public static void main(String[] args) {
        int[] inputs = new int[5];
        while(index<5){
            getInput(inputs);
        }
        System.out.println("array of integer is:");
        for (int input : inputs) {
            System.out.println(input + " ");
        }
    }
}
