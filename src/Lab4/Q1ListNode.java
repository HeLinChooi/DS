package Lab4;
//previous version at below

public class Q1ListNode<T> implements Comparable<Q1ListNode> {

    private T data;
    private Q1ListNode nextNode = null;
    private Q1ListNode previousNode = null;

    public Q1ListNode(T t, Q1ListNode b, Q1ListNode c) {
        this.data = t;
        previousNode = b;
        nextNode = c;
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

    public Q1ListNode getPreviousNode() {
        return previousNode;
    }

    public void setNextNode(Q1ListNode nextNode) {
        this.nextNode = nextNode;
    }

    public void setPreviousNode(Q1ListNode previousNode) {
        this.previousNode = previousNode;
    }

    @Override
    public String toString() {
        return data+"";
    }

    //dirty code
    public int compareTo(Q1ListNode obj) {
        if (Double.parseDouble(this.data.toString()) > Double.parseDouble(obj.data.toString())) {
            return 1;
        } else if (Double.parseDouble(this.data.toString()) < Double.parseDouble(obj.data.toString())) {
            return -1;
        } else {
            return 0;
        }
    }
}
