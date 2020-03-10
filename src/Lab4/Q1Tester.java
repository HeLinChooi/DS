package Lab4;

import java.util.Random;

public class Q1Tester {
    public static void main(String[] args) {
        Q1LinkedList<Integer> list = new Q1LinkedList<>();
        Q1LinkedList<Integer> reverseList = new Q1LinkedList<>();
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            list.addNode(r.nextInt(100));
        }
        for (int i = 0; i < 10; i++) {
            reverseList.addNodeAtFront((Integer)list.getNodeByPosition(i).getData());
        }
        list.showList();
        System.out.println("");
//        reverseList.showList();
        //sort the list
        System.out.println("\nsorting list...");
        list.sort();
        list.showList();System.out.println("");
        //question c
        list.addSortNode(50);
        list.showList();
//        Collections.sort(list);
    }
}
