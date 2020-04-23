package Tuto7;
//He Lin's code
public class Q2 {
    public static void main(String[] args) {
        BST<Character> tree = new BST<>();
        tree.addNode('F');
        tree.addNode('A');
        tree.addNode('C');
        tree.addNode('U');
        tree.addNode('L');
        tree.addNode('T');
        tree.addNode('Y');
        System.out.println("Number of elements in the tree:" + tree.getSize());
        System.out.println("Tree in preorder");
        tree.setOrder(BST.order.PREORDER);
        tree.showTree();
        System.out.println("Tree in inorder");
        tree.setOrder(BST.order.INORDER);
        tree.showTree();
        System.out.println("Tree in postorder");
        tree.setOrder(BST.order.POSTORDER);
        tree.showTree();
        tree.remove('L');
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
