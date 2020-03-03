package Tuto4;
//previous version at below
public class Q3ListNode<T> {
    private T data ;
    private Q3ListNode nextNode = null;
     public Q3ListNode(T t){
         this.data = t;
     }

    public T getData() {
        return data;
    }

    public Q3ListNode getNextNode() {
        return nextNode;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNextNode(Q3ListNode nextNode) {
        this.nextNode = nextNode;
    }
    
    @Override
    public String toString() {
        return data + "";
    }
     
}
