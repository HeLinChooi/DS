package Tuto5;

public class Q2ArrayStackImp<T> extends Q2ArrayStack {
    private T[] arr = (T[])new Object[maxSize];
    private int size = 0;
    @Override
    public boolean isEmpty() {
        return (size==0);
    }

    @Override
    public boolean isFull() {
        return (size==maxSize);
    }

    @Override
    public int getSize() {
        return size;
    }
    @Override
    public void push(Object t) {
        arr[size] = (T)t;
        size++;
    }
    //abstract class and interface is different, below works in interface but not here
//    @Override
//    public void push(T t) {
//        arr[size] = t;
//    }

    @Override
    public Object pop() {
        Object temp = arr[size-1];
        arr[size-1] = null;
        size--;
        return temp;
    }

    @Override
    public Object peek() {
        return arr[size-1];
    }

    @Override
    public void showStack() {
        for (int i = size-1; i >=0; i--) {
            System.out.print("<-- " + arr[i]);
        }
        System.out.println("");
    }
    
}
