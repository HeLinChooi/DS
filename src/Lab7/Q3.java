package Lab7;
//He Lin's code

public class Q3 {

    public static void main(String[] args) {
        Q3BSTExpression x = new Q3BSTExpression();
//        x.setExp("1+2");
//        x.setExp("1+2*5");
//        x.setExp("1*2+5");
//        x.setExp("(5*4+8)/7+2");
        x.getBST().showTree();
        System.out.print("INORDER : ");
        x.getBST().setOrder(Q1BST.order.INORDER);
        x.getBST().showTree();
        System.out.print("PREORDER : ");
        x.getBST().setOrder(Q1BST.order.PREORDER);
        x.getBST().showTree();
        System.out.print("POSTORDER : ");
        x.getBST().setOrder(Q1BST.order.POSTORDER);
        x.getBST().showTree();
    }
}
