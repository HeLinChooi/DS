package Tuto4;
//He Lin's code
public class Q6Tester {
    public static void main(String[] args) {
        Q6LinkedList<Integer> list = new Q6LinkedList<>();
        list.addNodeAtFront(78);
        list.addNodeAtFront(45);
        list.addNodeAtFront(34);
        list.addNodeAtFront(23);
        list.addNodeAtFront(17);
        list.addNodeAtFront(10);
        list.addNodeAtFront(8);
        list.showList();
        System.out.println("\nMedian is " + list.middleElement());
    }
}
