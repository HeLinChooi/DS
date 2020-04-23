package Tuto7;
//He Lin's code
public class Q3Tester {
    public static void main(String[] args) {
        ArrayBSTImp<String> t = new ArrayBSTImp<>();
        System.out.println("BST Implementation Using Array");
        t.addNode("F");
        t.addNode("A");
        t.addNode("C");
        t.addNode("U");
        t.addNode("L");
        t.addNode("T");
        t.addNode("Y");
        System.out.print("Preorder:");
        t.showBST();
        System.out.print("Inorder:");
        t.setOrder(2);
        t.showBST();
        System.out.print("Postorder:");
        t.setOrder(3);
        t.showBST();
        System.out.println("Remove 1 Character "+t.removeNode("O"));
        System.out.println("The number of elements in the tree : " + t.getSize());
        System.out.print("Preorder:");
        t.setOrder(1);
        t.showBST();
        System.out.print("Inorder:");
        t.setOrder(2);
        t.showBST();
        System.out.print("Postorder:");
        t.setOrder(3);
        t.showBST();
    }
}
