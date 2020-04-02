package Tuto6;
//He Lin's code
public class Q1Queue<T> {
    private Q1ListNode head;
    public Q1Queue(){}
    public boolean isEmpty(){return head==null;}
    public int getSize(){
        Q1ListNode temp = head;
        int size = 0;
        while(temp!=null){
            size++;
            temp = temp.getNextNode();
        }
        return size;
    }
    public T dequeue(){
        if(head==null){return null;}
        T temp = (T)head.getData();
        head = head.getNextNode();
        return temp;
    }
    public void enqueue(T t){
        Q1ListNode node = new Q1ListNode(t, null);
        Q1ListNode current = head;
        if(head==null){head = node;}
        else{
            while(current.getNextNode() !=null){
                current = current.getNextNode();
            }
            current.setNextNode(node);
        }
    }
    public T peek(){
        if(head==null){return null;}
        else{return (T)head.getData();}
    }
    public void showQueue(){
        if(isEmpty()){
            System.out.println("Empty Queue");
        }else{
            Q1ListNode current = head;
            while(current!=null){
                System.out.print(current.toString());
                current = current.getNextNode();
            }
            System.out.println("");
        }
    }
}
