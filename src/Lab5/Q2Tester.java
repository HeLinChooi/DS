package Lab5;
//power operator is not allowed

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Q2Tester {

    public static HashMap<Character, String> operand = new HashMap<>();

    public static int getPriority(char c) {
        switch (c) {
            case '*':
            case '/':
            case '%':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return 0;
        }
    }

    public static String infixToPostfix(String a) {
        String str = "";
        char c = ' ';
        Q1Stack<Character> stack = new Q1Stack<>();
        for (int i = 0; i < a.length(); i++) {
            char ch = a.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                str += ch;
            } else if (ch == '(') {
                stack.push(ch);
//                System.out.println("char is (");
//                stack.showStack();
            } else if (ch == ')') {
//                System.out.println("char is )");
                c = stack.pop();
                while (c != '(') {
                    str += c;
                    c = stack.pop();
                }
//                stack.showStack();
            } else {
                if (!stack.isEmpty()) {
                    if (stack.peek() == '(') {
                        stack.push(ch);
                    } else {
                        //it's operator
                        c = stack.peek();
                        while (getPriority(ch) <= getPriority(c)) {
//                            System.out.println("now: " + ch + " top: " + c);
                            //if the top elem has larger or same priority
                            str += stack.pop();
                            if (!stack.isEmpty()) {
                                c = stack.peek();
                                if (c == '(') {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        stack.push(ch);
//                        System.out.println("after pushing");
//                        stack.showStack();
                    }
                } else {
                    stack.push(ch);
                }
            }
        }
        while (!stack.isEmpty()) {
            str += stack.pop();
        }
        System.out.println("The postfix expression is: " + str);
        return str;
    }

    public static String convertOperator(String exp) {
        String[] arr = exp.split(" ");
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            Character cas = arr[i].charAt(0);
            if (Character.isLetter(cas)) {
                arr[i] = getOperator(arr[i]);
            }
        }
        //no need to add space as the method will add it automatically
        result = Arrays.toString(arr);
        result = result.substring(1, result.length() - 1);
        result = result.replace(",", "");
        System.out.println("The infix expression is:" + result);
        return result;
    }

    public static String getOperator(String o) {
        switch (o) {
            case "add":
                return "+";
            case "sub":
                return "-";
            case "mul":
                return "*";
            case "div":
                return "/";
            case "mod":
                return "%";
            case "ob":
                return "(";
            case "cb":
                return ")";
            default:
                return " Invalid Input ";
        }
    }

    public static String convertNumToChar(String exp) {
        String[] arr = exp.split(" ");
        String result = "";
        int startChar = 65;
        for (int i = 0; i < arr.length; i++) {
            Character cas = arr[i].charAt(0);
            if (Character.isDigit(cas)) {
                char temp = (char) startChar;
                operand.put(temp, arr[i]);
                arr[i] = temp + "";
                startChar++;
            }
        }
        result = Arrays.toString(arr);
        result = result.substring(1, result.length() - 1);
        result = result.replace(",", "");
        System.out.println("The infix expression become: " + result);
        return result;
    }

    public static String convertCharToNum(String exp) {
        String[] arr = exp.split("");
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            Character cas = arr[i].charAt(0);
            if (Character.isLetter(cas)) {
                result += operand.get(cas) + " ";
            } else {
                result += arr[i] + " ";
            }
        }
        System.out.println("The postfix expression become:" + result);
        return result;
    }

    public static int cal(String postfix) {
        String[] arr = postfix.split(" ");
        Stack<Integer> operands = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i].charAt(0);
            if (Character.isDigit(ch)) {
                operands.push(Integer.parseInt(arr[i]));
            } else {
//                System.out.println("operator!");
                int ans = simpleCal(operands, ch);
//                System.out.println("ans = " + ans);
                operands.push(ans);
            }
        }
        return operands.pop();
    }

    public static int simpleCal(Stack s, char ch) {
        int b = (int) s.pop();
        int a = (int) s.pop();
//        System.out.println("top 2: " + a + " " + b);
        switch (ch) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            case '%':
                return a % b;
            default:
                return Integer.MAX_VALUE;
        }
    }

    public static void allInOne(String exp) {
        exp = convertOperator(exp);
        exp = convertNumToChar(exp);
        exp = infixToPostfix(exp.replace(" ", ""));
        exp = convertCharToNum(exp);
        System.out.println("result : " + cal(exp));
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter infix expression : ");
        //sample test case
        //ob 300 mul 75 add 4350 cb div 15 add 1126
        //ob ob 5 add 8 cb sub ob 7 sub 3 cb cb mul 8 add 25 mod 3
        String exp = s.nextLine();
        allInOne(exp);
//        System.out.println(infixToPostfix("A+B"));
//        System.out.println(infixToPostfix("A*B+C"));
//        System.out.println(infixToPostfix("A+B*C"));
//        System.out.println(infixToPostfix("(A+B)*(C-D)"));
//        System.out.println(infixToPostfix("(A*B+C)/D+E"));
    }
}
