package Lab4;

public class Q2Tester {
    public static void main(String[] args) {
        Q2LinkedList<Character> test = new Q2LinkedList<>();
        Q2LinkedList<Character> test2 = new Q2LinkedList<>();
        test.addNode('a');
        test.addNode('b');
        test.addNode('c');
        test2.appendList(test);
        test.showList();
        test.splitList();
        System.out.println("");
        test2.alternateList();
        test2.mergeList();
    }
}
