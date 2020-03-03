package Tuto4;
public class Q1LinkedList<T> {
    private Q1ListNode<T> head;
    //correct ???
    public void moreThan20ThenAdd() {
        Q1ListNode temp = head;
        while(temp!=null){
            if(Double.parseDouble(temp.getData().toString())>20){
                temp.setData(Double.parseDouble(temp.getData().toString())+10.5);
            }
            temp = temp.getNextNode();
        }
    }

    public void addNode(T t) {
        Q1ListNode a = new Q1ListNode(t);
        Q1ListNode currentNode = head;
        if (head == null) {
            head = a;
        } else {
            while (currentNode.getNextNode() != null) {
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(a);
        }
    }

    public void clean() {
        head = null;
    }

    public int length() {
        int length = 0;
        Q1ListNode temp = head;
        while (temp != null) {
            temp = temp.getNextNode();
            length++;
        }
        return length;
    }

    public void showList() {
        Q1ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.toString());
            temp = temp.getNextNode();
        }
    }
}
