package Tuto4;

public class Q4Tester {

    public static void main(String[] args) {
        Q4LinkedList<Integer> list = new Q4LinkedList<>();
        list.addNode(23);
        list.addNode(15);
        list.addNode(17);
        list.addNode(28);
        list.addNode(12);
        list.addNode(40);
        list.showList();
        System.out.println("Total is " + list.sum());
        System.out.println(list.numOfEvenNum());
    }
}
