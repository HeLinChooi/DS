package Tuto7;
//He Lin's code

import Tuto6.Q1Queue;

public class BST<T extends Comparable<T>> {
    private BSTNode root;
    public boolean isEmpty(){
        return root==null;
    }
    public int getSize(){return getSize(root);}
    private int getSize(BSTNode a){
        if(a==null){return 0;}
        else{
            return getSize(a.getLeft()) + getSize(a.getRight()) + 1;
        }
    }
    public boolean contains(T t){
        return find(root,t);
    }
    private boolean find(BSTNode a,T t){
        if(a==null){return false;}
        else if(t.compareTo((T)a.getData())<0){
            return find(a.getLeft(),t);
        }else if(t.compareTo((T)a.getData())>0){
            return find(a.getRight(),t);
        }else{
            return true;
        }
    }
    public T getElement(BSTNode a,T t){
        if(a == null){return null;}
        else if(t.compareTo((T)a.getData())<0){
            return getElement(a.getLeft(),t);
        }else if(t.compareTo((T)a.getData())>0){
            return getElement(a.getRight(),t);
        }else{
            return (T)a.getData();
        }
    }
    public void addNode(T t){
        root = add(root,t);
    }
    private BSTNode add(BSTNode a,T t){
        if(a == null){
            a = new BSTNode(t, null, null);
        }else if(t.compareTo((T)a.getData())<0){
            a.setLeft(add(a.getLeft(),t));
        }else{
            a.setRight(add(a.getRight(),t));
        }
        return a;
    }
    private boolean found;
    public boolean remove(T t){
        root = remove(root,t);
        return found;
    }
    private BSTNode remove(BSTNode a,T t){
        if(a == null){
            found = false;
        }else if(t.compareTo((T)a.getData())<0){
            a.setLeft(remove(a.getLeft(), t));
        }else if(t.compareTo((T)a.getData())>0){
            a.setRight(remove(a.getRight(), t));
        }else{
            a = removeNode(a);
            found = true;
        }
        return a;
    }
    private BSTNode removeNode(BSTNode a){
        if(a.getLeft()==null){
            return a.getRight();
        }else if(a.getRight()==null){
            return a.getLeft();
        }else{
            T t = (T) getPredecessor(a.getLeft());
            a.setData(t);
            a.setLeft(remove(a.getLeft(),t));
            return a;
        }
    }
    private T getPredecessor(BSTNode a){
        while(a.getRight()!=null){
            a = a.getRight();
        }
        return (T)a.getData();
    }
    enum order{
        PREORDER,INORDER,POSTORDER;
    }
    Q1Queue<T> Q;
    public void showTree(){
        if(Q != null){
            Q.showQueue();
        }else{
            System.out.println("Please set the order.");
        }
    }
    public void setOrder(order x){
        Q = new Q1Queue<>();
        if(x == order.PREORDER){
            preorder(root);
        }else if(x == order.INORDER){
            inorder(root);
        }else{
            postorder(root);
        }
    }
    private void preorder(BSTNode a){
        if(a != null){
            Q.enqueue((T)a.getData());
            preorder(a.getLeft());
            preorder(a.getRight());
        }
    }
    private void inorder(BSTNode a){
        if(a != null){
            inorder(a.getLeft());
            Q.enqueue((T)a.getData());
            inorder(a.getRight());
        }
    }
    private void postorder(BSTNode a){
        if(a != null){
            postorder(a.getLeft());
            postorder(a.getRight());
            Q.enqueue((T)a.getData());
        }
    }
    public void balance(){
        int size = this.getSize();
        setOrder(BST.order.INORDER);
        T[] data = (T[]) new Comparable[size];
        for (int i = 0; i < size; i++) {
            data[i] = Q.dequeue();
        }
        root = null;
        insertBalanceTree(data,0,size-1);
    }
    private void insertBalanceTree(T[] t, int low,int high){
        if(low == high){
            this.addNode(t[low]);
        }else if((low + 1) == high){
            this.addNode(t[low]);
            this.addNode(t[high]);
        }else{
            int mid = (low + high)/2;
            this.addNode(t[mid]);
            insertBalanceTree(t, low, mid-1);
            insertBalanceTree(t, mid+1, high);
        }
    }
}
