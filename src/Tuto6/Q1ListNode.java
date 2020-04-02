package Tuto6;
//He Lin's code
public class Q1ListNode<T> {
    private T data;
    private Q1ListNode nextNode;
    public Q1ListNode(T t, Q1ListNode next) {
        data = t;
        nextNode = next;
    }
    public void setData(T t){data = t;}
    public T getData(){return data;}
    
    public void setNextNode(Q1ListNode node){nextNode = node;}
    public Q1ListNode getNextNode(){return nextNode;}
    
    public String toString(){return data + " --> ";}
}
