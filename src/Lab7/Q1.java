package Lab7;
//He Lin's code
public class Q1 {
    public static void main(String[] args) {
        Q1BST<Integer> k = new Q1BST<>();
        k.addNode(5);
        k.addNode(5);
        k.addNode(5);
        k.addNode(10);
        k.addNode(20);
        k.addNode(20);
        k.addNode(35);
        k.addNode(35);
        System.out.println(k.getMax());
        System.out.println(k.getMin());
        System.out.println(k.getTotal());
        System.out.println("Number of occurence of " + 
                5 + " is "+ k.getOccurenceNum(5));
    }
}
