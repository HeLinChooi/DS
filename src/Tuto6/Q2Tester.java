package Tuto6;
//He Lin's code
public class Q2Tester {
    public static void main(String[] args) {
        Q2ArrayQueueImp<Character> a = new Q2ArrayQueueImp<>();
        a.enqueue('A');
        a.enqueue('B');
        a.enqueue('C');
        a.enqueue('D');
        a.enqueue('E');
        a.enqueue('F');
        a.enqueue('G');
        a.enqueue('H');
        a.enqueue('I');
        a.enqueue('J');
        a.enqueue('M');
        a.enqueue('W');
        a.showQueue();
        System.out.println("dequeue:" + a.dequeue());
        a.showQueue();
        a.enqueue('M');
        a.showQueue();
        System.out.println("front:" + a.peek());
        System.out.println("size:" + a.getSize());
    }
}
