package Lab4;
//previous version at below
public class Q1ListNode<T>implements Comparable<Q1ListNode>  {
    private T data ;
    private Q1ListNode nextNode = null;
     public Q1ListNode(T t){
         this.data = t;
     }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Q1ListNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(Q1ListNode nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return data + "---->";
    }
    //dirty code
     public int compareTo(Q1ListNode obj){
         if(Double.parseDouble(this.data.toString())>Double.parseDouble(obj.data.toString())){
             return 1;
         }else if(Double.parseDouble(this.data.toString())<Double.parseDouble(obj.data.toString())){
             return -1;
         }else{
             return 0;
         }
     }
}