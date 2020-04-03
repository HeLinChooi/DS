package Tuto5;

public class Q1Stack<T> {
    private Q1ListNode head;
    public boolean isEmpty(){
        return (head == null);
    }
    public int getSize(){
        Q1ListNode current = head;
        int count = 0;
        while(current!=null){
            current = current.getNextNode();
            count++;
        }
        return count;
    }
    public void push(T t){
        Q1ListNode temp = new Q1ListNode(t, head);
        head = temp;
    }
    public T pop(){
        if(head == null){
            return null;
        }
        T temp = (T)head.getData();
        head = head.getNextNode();
        return temp;
    }
    public T peek(){
        return (T)head.getData();
    }
    public void showStack(){
        if(head==null){
            System.out.println("The stack is empty.");
        }
        Q1ListNode current = head;
        while(current!=null){
            System.out.print("<--" + current.getData().toString());
            current = current.getNextNode();
        }
        System.out.println("");
    }
    
}
