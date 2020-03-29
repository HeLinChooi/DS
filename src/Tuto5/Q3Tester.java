package Tuto5;

import java.util.Scanner;

public class Q3Tester {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Q1Stack<Character> ch = new Q1Stack<>();
        Q1Stack<String> str = new Q1Stack<>();
        System.out.print("Enter a sentence:");
        String sen = s.nextLine();
        System.out.println("Ori sentence : " + sen);
        String[] words = sen.split(" ");
        //push into stacks
        for (int i = 0; i < sen.length(); i++) {
            ch.push(sen.charAt(i));
        }
        for (int i = 0; i < words.length; i++) {
            str.push(words[i]);
        }
        System.out.print("Sentence in reverse order : ");
        for (int i = 0; i < sen.length(); i++) {
            System.out.print(ch.pop());
        }
        System.out.print("\nThe word in reverse order : ");
        for (int i = 0; i < words.length; i++) {
            System.out.print(str.pop() + " ");
        }
        s.close();
    }
}
