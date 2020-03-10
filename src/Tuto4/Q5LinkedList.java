package Tuto4;
//using Q3 ListNode

import java.util.Random;

public class Q5LinkedList<T> {

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
            System.out.print(temp.toString() + "-->");
            temp = temp.getNextNode();
        }
    }
    //Q5 requirement
    static Random r = new Random();

    public int ran() {
        return r.nextInt(11);
    }

    public void deleteNode(int x) {
        Q3ListNode temp = head;
        Q3ListNode previousTemp = head;
        if (temp == null) {
            System.out.println("The list is empty.");
        }
        while (temp != null) {
            boolean xAtHead = false;
            if (temp.getData().toString().equals(x + "")) {
                if (temp.getNextNode() != null) {
                    if (temp == previousTemp) {
                        temp = temp.getNextNode();
                        head = temp;
                        previousTemp = temp;
                        xAtHead = true;
                    } else {
                        previousTemp.setNextNode(temp.getNextNode());
                    }
                }else{
                    previousTemp.setNextNode(null);
                }
            }
            if(!xAtHead){
                previousTemp = temp;
                temp = temp.getNextNode();
            }
        }
    }

}
