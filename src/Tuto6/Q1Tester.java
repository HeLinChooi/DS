package Tuto6;
//He Lin's code
public class Q1Tester {
    public static void main(String[] args) {
        Q1Queue<Character> c = new Q1Queue<>();
        c.enqueue('B');
        c.enqueue('M');
        c.enqueue('W');
        c.showQueue();
        c.dequeue();
        c.showQueue();
        System.out.println("front:" + c.peek());
        System.out.println("size:" + c.getSize());
    }
}
