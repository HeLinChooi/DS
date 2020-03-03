package Tuto4;
//previous version at below
public class Q1ListNode<T> {
    private T data ;
    private Q1ListNode nextNode = null;
     public Q1ListNode(T t){
         this.data = t;
     }

    public T getData() {
        return data;
    }

    public Q1ListNode getNextNode() {
        return nextNode;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNextNode(Q1ListNode nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return data + "---->";
    }
}
//public class ListNode<T> {
//    private T data ;
//    private ListNode nextNode = null;
//     public ListNode(T t){
//         data = t;
//     }
//
//    public T getData() {
//        return data;
//    }
//
//    public ListNode getNextNode() {
//        return nextNode;
//    }
//
//    public void setData(T data) {
//        this.data = data;
//    }
//
//    public void setNextNode(ListNode nextNode) {
//        this.nextNode = nextNode;
//    }
//
//    @Override
//    public String toString() {
//        return data + "---->";
//    }
//     
//}
