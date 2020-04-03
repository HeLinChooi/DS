package Lab5;
//He Lin's code

import java.util.Scanner;
import java.util.Stack;

public class Q4 {

    public static void evaluate(String str) {
        Stack<Character> stack = new Stack<>();
        boolean balance = true;
        System.out.println(str);
        for (int i = 0; i < str.length(); i++) {
            //skip!
            if (str.charAt(i) == '\\') {
                i += 2;
            }
            if (!isTarget(stack, str.charAt(i), i)) {
                balance = false;
            };
        }
        for (int i = 0; i < stack.size(); i++) {
            balance = false;
            char c = stack.pop();
            System.out.printf("%" + (str.length() - 1) + "s", " ");
            miss(c);
        }
        if (balance) {
            System.out.println("The expression is balanced");
        }
    }

    public static boolean isTarget(Stack s, char c, int index) {
        boolean balance = true;
        switch (c) {
            case '(':
                s.push(c);
                return true;
            case '[':
                s.push(c);
                return true;
            case '{':
                s.push(c);
                return true;
            case ')':
                if(!s.isEmpty()){c = (char) s.pop();}
                else{extra(c,index);return false;}
                while (!(c == '(') && !s.isEmpty()) {
//                    System.out.println(index);
                    System.out.printf("%" + index + "s", " ");
                    miss(c);
                    if(!s.isEmpty()){c = (char) s.pop();}
                    else{break;}
                    balance = false;
                }
                return balance;
            case ']':
                if(!s.isEmpty()){c = (char) s.pop();}
                else{extra(c,index);return false;}
                while (!(c == '[') && !s.isEmpty()) {
//                    System.out.println(index);
                    System.out.printf("%" + index + "s", " ");
                    miss(c);
                    if(!s.isEmpty()){c = (char) s.pop();}
                    else{break;}
                    balance = false;
                }
                return balance;
            case '}':
                if(!s.isEmpty()){c = (char) s.pop();}
                else{extra(c,index);return false;}
                while (!(c == '{') && !s.isEmpty()) {
//                    System.out.println(index);
                    System.out.printf("%" + index + "s", " ");
                    miss(c);
                    if(!s.isEmpty()){c = (char) s.pop();}
                    else{break;}
                    balance = false;
                }
                return balance;
            default:
                return true;
        }
    }

    public static void miss(char c) {
        switch (c) {
            case '(':
                System.out.println("^ Missing )");
                break;
            case '[':
                System.out.println("^ Missing ]");
                break;
            case '{':
                System.out.println("^ Missing }");
                break;
            default:
                System.out.println("error" + c);
        }
    }
    public static void extra(char c,int index){
        System.out.printf("%" + index + "s", " ");
        System.out.println("^ Extra " + c);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //template
//        System.out.println(str.charAt(3);
//        System.out.println("\(No Error");
//        int[] num = 1, 2};
//        if(arr[{3] < 4);
        for (int i = 0; i < 4; i++) {
            System.out.print("Enter a expression : ");
            evaluate(s.nextLine());
        }
    }
}
