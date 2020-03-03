package Tuto4;
//using Q3LinkedList
public class Q6LinkedList<T> {
    private Q3ListNode<T> head;
    public void addNode(T t) {
        Q3ListNode a = new Q3ListNode(t);
        Q3ListNode currentNode = head;
        if (head == null) {
            head = a;
        } else {
            while (currentNode.getNextNode() != null) {
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(a);
        }
    }

    public Q3ListNode getNodeByPosition(int findIndex) {
        Q3ListNode temp = head;
        int index = 0;
        while (temp != null) {
            if (index == findIndex) {
                return temp;
            }
            temp = temp.getNextNode();
            index++;
        }
        return null;
    }

    public void clean() {
        head = null;
    }

    public int length() {
        int length = 0;
        Q3ListNode temp = head;
        while (temp != null) {
            temp = temp.getNextNode();
            length++;
        }
        return length;
    }
    public void addNodeAtFront(T t){
        Q3ListNode a = new Q3ListNode(t);
        if (head == null) {
            head = a;
        } else {
            a.setNextNode(head);
            head = a;
        }
    }
    public int middleElement(){
        Q3ListNode temp = head;
        for (int i = 0; i < size()/2; i++) {
            temp = temp.getNextNode();
        }
        if(size()%2==0){
            int nextNodeValue = Integer.parseInt(temp.getNextNode().getData().toString());
            return (Integer.parseInt(temp.getData().toString()) + nextNodeValue)/2;
        }else{
            return Integer.parseInt(temp.getData().toString());
        }
    }
    public int size(){
        Q3ListNode temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.getNextNode();
        }
        return size;
    }
    public void showList() {
        Q3ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.toString() + "-->");
            temp = temp.getNextNode();
        }
    }
}
