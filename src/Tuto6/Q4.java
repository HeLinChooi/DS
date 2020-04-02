package Tuto6;
//He Lin's code

import java.util.Stack;

public class Q4 {
    public static boolean palin(String str){
        Stack<Character> a = new Stack<>();
        Stack<Character> temp = new Stack<>();
        Stack<Character> b = new Stack<>();
        //get
        for (int i = 0; i < str.length(); i++) {
            a.push(str.charAt(i));
            temp.push(str.charAt(i));
        }
        //copy the stack in reverse
        for (int i = 0; i < a.size(); i++) {
            b.push(temp.pop());
        }
        boolean palin = true;
        //compare stack a and stack b
        for (int i = 0; i < a.size(); i++) {
            if(!(a.pop().equals(b.pop()))){
                palin = false;
                break;
            }
        }
        return palin;
    }
    public static void main(String[] args) {
        //use 2 stack
        String s = "kayak";
        System.out.println(s + ":" + palin(s));
        String s2 = "Welcome";
        System.out.println(s2 + ":" + palin(s2));
        String s3 = "Was it a car or a cat I saw?";
        System.out.println(s3 + ":" + palin(s3));
        String s4 = "civic";
        System.out.println(s4 + ":" + palin(s4));
        String s5 = "race car";
        System.out.println(s5 + ":" + palin(s5));
    }
}
