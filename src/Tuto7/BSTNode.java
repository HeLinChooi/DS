package Tuto7;
//He Lin's code
public class BSTNode<T> {
    private T data;
    private BSTNode rightNode;
    private BSTNode leftNode;
    
    public BSTNode(T t,BSTNode left,BSTNode right){
        data = t;
        leftNode = left;
        rightNode = right;
    }

    public T getData() {
        return data;
    }

    public BSTNode getRight() {
        return rightNode;
    }

    public BSTNode getLeft() {
        return leftNode;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setRight(BSTNode rightNode) {
        this.rightNode = rightNode;
    }

    public void setLeft(BSTNode leftNode) {
        this.leftNode = leftNode;
    }
    
}
