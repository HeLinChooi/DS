package Tuto7;
//He Lin's code
public abstract class ArrayBST<T extends Comparable<T>> {
    //what's the purpost of the contructor? LOL
    public ArrayBST(){}
    public abstract boolean isEmpty();
    public abstract int getSize();
    public abstract int getheight();
    public abstract void addNode(T t);
    public abstract void setOrder(int x);
    protected abstract void inOrder(int x);
    protected abstract void preOrder(int x);
    protected abstract void postOrder(int x);
    public abstract T removeNode(T t);
}
