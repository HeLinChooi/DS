package Tuto7;
//He Lin's code
public class Q1 {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        tree.addNode(50);
        tree.addNode(30);
        tree.addNode(25);
        tree.addNode(71);
        tree.addNode(80);
        tree.addNode(99);
        tree.addNode(40);
        tree.addNode(1);
        tree.addNode(7);
        tree.addNode(5);
        System.out.println("Tree in preorder");
        tree.setOrder(BST.order.PREORDER);
        tree.showTree();
        System.out.println("Tree in inorder");
        tree.setOrder(BST.order.INORDER);
        tree.showTree();
        System.out.println("Tree in postorder");
        tree.setOrder(BST.order.POSTORDER);
        tree.showTree();
    }
}
