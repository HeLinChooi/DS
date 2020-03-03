package Tuto4;

public class Q3LinkedList<T> {

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

    public void showList() {
        Q3ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.toString());
            temp = temp.getNextNode();
        }
    }
}
