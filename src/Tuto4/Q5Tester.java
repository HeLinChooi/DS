package Tuto4;
//He Lin's code
public class Q5Tester {

    public static void main(String[] args) {
        Q5LinkedList<Integer> list = new Q5LinkedList<>();

        for (int i = 0; i < 15; i++) {
            list.addNode(list.ran());
        }
        list.showList();
        list.deleteNode(4);
        System.out.println("");
        list.showList();
    }
}
