package Lab7;
//He Lin's code

import Lab4.Q2LinkedList;
import Tuto6.Q1Queue;
import Tuto7.BSTNode;
import java.util.HashMap;

public class Q1BST<T extends Comparable<T>> {

    private BSTNode root;
   //added for levelOrder method 
    public BSTNode getRoot(){
        return root;
    }
    public boolean isEmpty() {
        return root == null;
    }

    public int getSize() {
        return getSize(root);
    }

    private int getSize(BSTNode a) {
        if (a == null) {
            return 0;
        } else {
            return getSize(a.getLeft()) + getSize(a.getRight()) + 1;
        }
    }

    public boolean contains(T t) {
        return find(root, t);
    }
    
    //here the 'root' refer to root in a subtree
    private boolean find(BSTNode root, T t) {
        if (root == null) {
            return false;
        } else if (t.compareTo((T) root.getData()) < 0) {
            return find(root.getLeft(), t);
        } else if (t.compareTo((T) root.getData()) > 0) {
            return find(root.getRight(), t);
        } else {
            return true;
        }
    }
    //here the 'root' refer to root in a subtree
    public T getElement(BSTNode root, T t) {
        if (root == null) {
            return null;
        } else if (t.compareTo((T) root.getData()) < 0) {
            return getElement(root.getLeft(), t);
        } else if (t.compareTo((T) root.getData()) > 0) {
            return getElement(root.getRight(), t);
        } else {
            return (T) root.getData();
        }
    }

    public void addNode(T t) {
        root = add(root, t);
    }

    private BSTNode add(BSTNode a, T t) {
        if (a == null) {
            a = new BSTNode(t, null, null);
        } else if (t.compareTo((T) a.getData()) < 0) {
            a.setLeft(add(a.getLeft(), t));
        } else {
            a.setRight(add(a.getRight(), t));
        }
        return a;
    }
    private boolean found;

    public boolean remove(T t) {
        root = remove(root, t);
        return found;
    }

    private BSTNode remove(BSTNode a, T t) {
        if (a == null) {
            found = false;
        } else if (t.compareTo((T) a.getData()) < 0) {
            a.setLeft(remove(a.getLeft(), t));
        } else if (t.compareTo((T) a.getData()) > 0) {
            a.setRight(remove(a.getRight(), t));
        } else {
            a = removeNode(a);
            found = true;
        }
        return a;
    }

    private BSTNode removeNode(BSTNode a) {
        if (a.getLeft() == null) {
            return a.getRight();
        } else if (a.getRight() == null) {
            return a.getLeft();
        } else {
            T t = (T) getPredecessor(a.getLeft());
            a.setData(t);
            a.setLeft(remove(a.getLeft(), t));
            return a;
        }
    }

    private T getPredecessor(BSTNode a) {
        while (a.getRight() != null) {
            a = a.getRight();
        }
        return (T) a.getData();
    }

    enum order {
        PREORDER, INORDER, POSTORDER;
    }
    Q1Queue<T> Q;

    public void showTree() {
        if (Q != null) {
            Q.showQueue();
        } else {
            System.out.println("Please set the order.");
        }
    }

    public void setOrder(order x) {
        Q = new Q1Queue<>();
        if (x == order.PREORDER) {
            preorder(root);
        } else if (x == order.INORDER) {
            inorder(root);
        } else {
            postorder(root);
        }
    }

    private void preorder(BSTNode a) {
        if (a != null) {
            Q.enqueue((T) a.getData());
            preorder(a.getLeft());
            preorder(a.getRight());
        }
    }

    private void inorder(BSTNode a) {
        if (a != null) {
            inorder(a.getLeft());
            Q.enqueue((T) a.getData());
            inorder(a.getRight());
        }
    }

    private void postorder(BSTNode a) {
        if (a != null) {
            postorder(a.getLeft());
            postorder(a.getRight());
            Q.enqueue((T) a.getData());
        }
    }
    //not functioning but will give u the idea of BFS
    public void levelOrder(BSTNode root) {
    if (root == null) return;
    Q1Queue<BSTNode> q = new Q1Queue<>();
    q.enqueue(root); // add first level to queue
    int nodeCountInLevel = 1;
        while (!q.isEmpty()) {
            BSTNode x = q.dequeue();
            nodeCountInLevel--;
            if (x.getLeft()!= null)
                q.enqueue(x.getLeft());
            if (x.getRight() != null)
                q.enqueue(x.getRight());

            // move to next level when all nodes are processed in current level
            if (nodeCountInLevel == 0 && !q.isEmpty()) {
                nodeCountInLevel += q.getSize();
                q.showQueue();
            }
        }
}
    public void balance() {
        int size = this.getSize();
        setOrder(Q1BST.order.INORDER);
        T[] data = (T[]) new Comparable[size];
        for (int i = 0; i < size; i++) {
            data[i] = Q.dequeue();
        }
        root = null;
        insertBalanceTree(data, 0, size - 1);
    }

    private void insertBalanceTree(T[] t, int low, int high) {
        if (low == high) {
            this.addNode(t[low]);
        } else if ((low + 1) == high) {
            this.addNode(t[low]);
            this.addNode(t[high]);
        } else {
            int mid = (low + high) / 2;
            this.addNode(t[mid]);
            insertBalanceTree(t, low, mid - 1);
            insertBalanceTree(t, mid + 1, high);
        }
    }

    //The methods requested by question 1
    public int getMax() {
        if (root != null) {
            if (root.getData() instanceof Integer) {
                BSTNode temp = root;
                T t = (T) root.getData();
                while (temp.getRight() != null) {
                    temp = temp.getRight();
                }
                return (int) temp.getData();
            } else {
                System.out.println("only applicable to integer");
                return -1;
            }
        }else{
            return -1;
        }
    }
    public int getMin() {
        if (root != null) {
            if (root.getData() instanceof Integer) {
                BSTNode temp = root;
                T t = (T) root.getData();
                while (temp.getLeft() != null) {
                    temp = temp.getLeft();
                }
                return (int) temp.getData();
            } else {
                System.out.println("only applicable to integer");
                return -1;
            }
        }else{
            return -1;
        }
    }
    public int getTotal(){
        if (root != null) {
            if (root.getData() instanceof Integer) {
                return getTotalInt(root);
            } else {
                System.out.println("only applicable to integer");
                return -1;
            }
        }else{
            return -1;
        }
    }
    public int getTotalInt(BSTNode a){
        int total = 0;
        total += (int)a.getData();
        if(a.getLeft()!=null){ total += getTotalInt(a.getLeft());}
        if(a.getRight()!=null){total +=getTotalInt(a.getRight());}
        return total;
    }
    public int getOccurenceNum(T t){
        return getOccNum(root, t);
    }
    private int getOccNum(BSTNode a,T t){
        int total = 0;
        if(a.getData()==t){
            total++;
        }
        if(a.getLeft()!=null){ total += getOccNum(a.getLeft(),t);}
        if(a.getRight()!=null){total +=getOccNum(a.getRight(),t);}
        return total;
    }
    //method for lab7Q2
    public HashMap freqCounter(){
        setOrder(order.INORDER);
        if(root.getData() instanceof String){
            HashMap<String,Integer> freq = new HashMap<>();
            String previous = (String)Q.dequeue();
            freq.put(previous, 1);
            String current = (String)Q.dequeue();
            while(!Q.isEmpty()){
                if(current.equals(previous)){
                    int t = freq.get(current);
                    freq.replace(current,++t);
                    current = (String)Q.dequeue();
                }else{
                    freq.put(current, 1);
                    previous = current;
                    current = (String)Q.dequeue();
                }
            }
            if(current.equals(previous)){
                    int t = freq.get(current);
                    freq.replace(current,++t);
                }else{
                    freq.put(current, 1);
                }
            return freq;
        }else{
            return null;
        }
    }
    //methods for lab7Q3
    public void setLeftNode(Q1BST n){
        root.setLeft(n.root);
    }
    public void setRightNode(Q1BST n){
        root.setRight(n.root);
    }
}
