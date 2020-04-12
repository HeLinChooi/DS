package Lab6;
//He Lin's code

import Tuto6.Q1Queue;
import java.util.Scanner;


public class Q1 {

    private static int amount = 500;

    public static void operation(char c, int total) {
        switch (c) {
            case 'W':
                amount -= total;
                String temp = "Withdraw " + total;
                if (amount < 0) {
                    temp += " Rejected";
                    amount += total;
                }
                System.out.printf("%-25s New Balance %d\n",temp, amount);
                break;
            case 'D':
                amount += total;
                System.out.printf("%-25s New Balance %d\n","Deposit " + total, amount);
                break;
            default:
                System.out.println("Invalid input.");
        }
    }
    // D 400 | W 300 | W 700 | D 200 | D 450 | W 120
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        System.out.print("Enter transactions :");
        String str = s.nextLine().trim();
        String[] op = str.split("\\|");
        Q1Queue<String> ops = new Q1Queue<>();
        for (String op1 : op) {
            System.out.println(op1.trim());
            ops.enqueue(op1.trim());
        }
        //start operations
        System.out.println("Initial Balance : " + amount);
        while(!ops.isEmpty()){
            String[] temp = ops.dequeue().split(" ");
            operation(temp[0].charAt(0), Integer.parseInt(temp[1]));
        }
    }
}
