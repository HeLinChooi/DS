package Tuto6;
//He Lin's code

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q6 {
    public static Queue reverseQueue(String str){
        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();
        //try this, same result come out?
//        LinkedList<String> q2 = new LinkedList<>();
        String[] words = str.split(" ");
        q1.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if(i%2==0){
                q1.add(words[i]);
                while (!q2.isEmpty()) {
                    q1.add(q2.remove());
                }
            }else{
                q2.add(words[i]);
                while (!q1.isEmpty()) {
                    q2.add(q1.remove());
                }
            }
        }
//        System.out.println("q1");
//        while(!q1.isEmpty()){
//            System.out.print(q1.remove() + " --> ");
//        }
//        System.out.println("q2");
//        for (int i = 0; i < q2.size();) {
//            System.out.print(q2.remove() + " --> ");
//        }
        return (words.length%2==0)?q2:q1;
    }
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        System.out.print("Enter sentence:");
        String str = s.nextLine();
        String[] temp = str.split(" ");
        for (String temp1 : temp) {
            System.out.print(temp1 + " --> ");
        }
        System.out.println("");
        Queue<String> reverse = reverseQueue(str);
        System.out.println(reverse);
        for (int i = 0; i < reverse.size();) {
            System.out.print(reverse.remove() + " --> ");
        }
    }
}
