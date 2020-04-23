package Tuto7;
//He Lin's code

import Tuto6.Q1Queue;

public class ArrayBSTImp<T extends Comparable<T>> extends ArrayBST<T> {

    int maxSize = 20;
    int size = 0;
    int height = 0;
    int root = 0;
    T[] tree;

    public ArrayBSTImp() {
        tree = (T[]) new Comparable[maxSize];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getheight() {
        return height;
    }

    @Override
    public void addNode(T t) {
        addTreeNode(root, t);
        size++;
    }

    public void addTreeNode(int index, T input) {
//        System.out.println("Index:" + index
//                + " initial value:" + tree[index]
//                + " input :" + input);
        if (tree[index] == null) {
//            System.out.println("null! put input into above index!");
            tree[index] = input;
        } else if (input.compareTo(tree[index]) > 0) {
            addTreeNode(index * 2 + 2, input);
        } else if (input.compareTo(tree[index]) <= 0) {
            addTreeNode(index * 2 + 1, input);
        }
    }
    Q1Queue<T> q;

    @Override
    public void setOrder(int x) {
        q = new Q1Queue<>();
        switch (x) {
            case 1:
                preOrder(0);
                break;
            case 2:
                inOrder(0);
                break;
            case 3:
                postOrder(0);
                break;
            default:
                System.out.println("Invalid integer.\n"
                        + "1-Preorder, 2-Inorder, 3-Postorder");
        }
    }

    @Override
    protected void inOrder(int index) {
        if (!(2 * index + 1 > maxSize)) {
            if (tree[2 * index + 1] != null) {
                inOrder(2 * index + 1);
            }
        }
        if (tree[index] != null) {
            q.enqueue(tree[index]);
        }
        if (!(2 * index + 1 > maxSize)) {
            if (tree[2 * index + 2] != null) {
                inOrder(2 * index + 2);
            }
        }
    }

    @Override
    protected void preOrder(int index) {
        if (tree[index] != null) {
            q.enqueue(tree[index]);
        }
        if (!(2 * index + 1 > maxSize)) {
            if (tree[2 * index + 1] != null) {
                preOrder(2 * index + 1);
            }
            if (tree[2 * index + 2] != null) {
                preOrder(2 * index + 2);
            }
        }
    }

    @Override
    protected void postOrder(int index) {
        if (!(2 * index + 1 > maxSize)) {
            if (tree[2 * index + 1] != null) {
                postOrder(2 * index + 1);
            }
            if (tree[2 * index + 2] != null) {
                postOrder(2 * index + 2);
            }
        }
        if (tree[index] != null) {
            q.enqueue(tree[index]);
        }
    }

    public void showBST() {
        if (q == null) {
            //default order is preorder
            q = new Q1Queue<>();
            preOrder(0);
            q.showQueue();
        } else {
            q.showQueue();
        }
    }

    @Override
    public T removeNode(T t) {
        T temp = remove(0, t);
        if(temp!=null){size--;}
        return temp;
    }

    public T remove(int index, T input) {
        if (index < maxSize) {
//            System.out.println("now " + tree[index]);
            T temp = null;
            if (tree[index] == input) {
                temp = tree[index];
                if (tree[2 * index + 1] == null && tree[2 * index + 2] == null) {
                    tree[index] = null;
                }else if (tree[2 * index + 1] == null) {
                    tree[index] = tree[2 * index + 2];
                    tree[2 * index + 2] = null;
                }else if (tree[2 * index + 2] == null) {
                    tree[index] = tree[2 * index + 1];
                    tree[2 * index + 1] = null;
                }else{
                    //this node has 2 children, so go left first
                    findReplaceNode(2*index+1);
                }
            } else if (input.compareTo(tree[index]) > 0) {
                temp = remove(index * 2 + 2, input);
            } else if (input.compareTo(tree[index]) <= 0) {
                temp = remove(index * 2 + 1, input);
            }
            return temp;
        }else{
            return null;
        }
    }
   

    public T findReplaceNode(int index) {
        T t = tree[index];
        while(index < maxSize){
            t = tree[index];
            index = 2*index + 2;
        }
        tree[(index-2)/2] = null;
        return t;
    }
}
