package Lab4;

import java.nio.file.Files;

public class Q2Tester {

    public static void main(String[] args) {
        Q2LinkedList<Character> test = new Q2LinkedList<>();
        Q2LinkedList<Character> testA = new Q2LinkedList<>();
        Q2LinkedList<Character> testB = new Q2LinkedList<>();
        Q2LinkedList<Character> testC = new Q2LinkedList<>();
        test.addNode('a');
        test.addNode('b');
        test.addNode('c');
        test.addNode('d');
        test.addNode('e');
        test.addNode('f');
        test.addNode('g');
//        test.addNode('h');
//        test2.appendList(test);
        test.showList();
//        test.splitList(testA);
//        testA.showList();
        System.out.println("");
        test.alternateList(testB);
        testC = test.mergeList(testB);
        testC.showList();
        System.out.println(test.size());
        System.out.println(test.deleteNodebyPosition(1).getData().toString());
        System.out.println("size " + test.size());
        test.showList();
        test.reverseTheList();
        System.out.println("size " + test.size());
        test.showList();
        reverseTheList(test);
        test.showList();
    }
    public static void reverseTheList(Q2LinkedList l){
        reverseTheList(l,0);
    }
    public static void reverseTheList(Q2LinkedList l,int pos){
        if (pos == (l.size() - 1)) {
            l.addNode(l.deleteNodebyPosition(pos));
        } else {
            reverseTheList(l,pos + 1);
            l.addNode(l.deleteNodebyPosition(pos));
        }
    }
}
