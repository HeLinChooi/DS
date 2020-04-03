package Lab5;
public class Q1ListNode<T> {
    private T data;
    private Q1ListNode nextNode;
    public Q1ListNode(T data, Q1ListNode nextNode) {
        this.data = data;
        this.nextNode = nextNode;
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
        return data + "";
    }
}
