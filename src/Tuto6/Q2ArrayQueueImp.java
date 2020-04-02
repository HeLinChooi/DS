package Tuto6;
//He Lin's code
public class Q2ArrayQueueImp<T> extends Q2ArrayQueue<T>{
    private T[] arr;
    private int size;
    private int rear;
    private int head;
    public Q2ArrayQueueImp(){
        arr = (T[]) new Object[maxSize];
        head = 0;
        rear = 0;
    }
    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean isFull() {
        return size == maxSize;
    }

    @Override
    public int getSize() {return size;}

    @Override
    public void enqueue(T t) {
        if(arr[rear%maxSize] == null){
            arr[rear%maxSize] = t;
            size++;
            rear++;
        }else{
            System.out.println("Full");
        }
    }

    @Override
    public T dequeue() {
        size--;
        T temp = arr[head%maxSize];
        arr[head%maxSize] = null;
        head = (head+1)%maxSize;
        return temp;
    }

    @Override
    public T peek() {
        return arr[head];
    }

    @Override
    public void showQueue() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[(head + i)%maxSize] + " --> ");
        }
        System.out.println("");
    }

}
