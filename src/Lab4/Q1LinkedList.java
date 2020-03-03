package Lab4;

import java.util.Collections;
import java.util.List;
//what's the diff?
//public class Q1LinkedList<T extends Comparable<T>>{

public class Q1LinkedList<T extends Comparable<T>> {

    private Q1ListNode head;

    public Q1LinkedList() {
    }

    public Q1LinkedList(T t) {
        Q1ListNode a = new Q1ListNode(t);
        head = a;
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

    public int size() {
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

    public void addNodeAtFront(T t) {
        Q1ListNode a = new Q1ListNode(t);
        if (head == null) {
            head = a;
        } else {
            a.setNextNode(head);
            head = a;
        }
    }

    public Q1ListNode getNodeByPosition(int findIndex) {
        Q1ListNode temp = head;
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

    public void deleteNode(int x) {
        Q1ListNode temp = head;
        Q1ListNode previousTemp = head;
        if (temp == null) {
            System.out.println("The list is empty.");
        }
        while (temp != null) {
            if (temp.getData().toString().equals(x + "")) {
                if (temp.getNextNode() != null) {
                    previousTemp.setNextNode(temp.getNextNode());
                } else {
                    previousTemp.setNextNode(null);
                }
            }
            previousTemp = temp;
            temp = temp.getNextNode();
        }
    }

    public void sort() {
        Q1ListNode previous = head;
        Q1ListNode current = head;
        if (head != null) {
            if (head.getNextNode() != null) {
                current = head.getNextNode();
            }
            for (int i = 0; i < size(); i++) {
                for (int j = 0; j < size(); j++) {
                }

            }
        } else {
            System.out.println("The list is empty.");
        }
    }

}
