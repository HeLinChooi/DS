package Tuto5;

abstract class Q2ArrayStack<T> {
    protected int maxSize = 10;
    public Q2ArrayStack(){};
    public abstract boolean isEmpty();
    public abstract boolean isFull();
    public abstract int getSize();
    public abstract void push(T t);
    public abstract T pop();
    public abstract T peek();
    public abstract void showStack();
}
