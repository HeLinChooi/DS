package Tuto5;

public class Q2Tester {
    public static void main(String[] args) {
        Q2ArrayStackImp<Character> a = new Q2ArrayStackImp<>();
        a.push('A');
        a.push('N');
        a.push('D');
        a.showStack();
        System.out.println("pop");
        a.pop();
        a.showStack();
        System.out.println("top element:" + a.peek());
        a.showStack();
        System.out.println("size:" + a.getSize());
    }
}
