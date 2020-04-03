package Tuto5;

public class Q1Tester {
    public static void main(String[] args) {
        Q1Stack<Character> a = new Q1Stack<>();
        System.out.println("Insert three nodes into the stack");
        a.push('A');
        a.push('N');
        a.push('D');
        a.showStack();
        System.out.println("Pop one node");
        a.pop();
        a.showStack();
        System.out.println("The element on the top of the stack is " + a.peek());
        System.out.println("The number of elements : " + a.getSize());
    }
}
