package Tuto6;
//He Lin's code
public abstract class Q2ArrayQueue<T> {
    public Q2ArrayQueue(){};
    protected int maxSize = 10;
    public abstract boolean isEmpty();
    public abstract boolean isFull();
    public abstract int getSize();
    public abstract void enqueue(T t);
    public abstract T dequeue();
    public abstract T peek();
    public abstract void showQueue();
}
