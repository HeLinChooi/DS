package Lab6;
//He Lin's code

import Tuto6.Q1ListNode;

public class Q5PriorityQueue<T> {

    private Q1ListNode head;

    public Q5PriorityQueue() {
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        Q1ListNode temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.getNextNode();
        }
        return size;
    }

    public T dequeue() {
        if (head == null) {
            return null;
        }
        T temp = (T) head.getData();
        head = head.getNextNode();
        return temp;
    }

    //modified for Priority Queue
    public void enqueue(T t) {
        Q1ListNode node = new Q1ListNode(t, null);
        Q1ListNode current = head;
        if (head == null) {
            head = node;
        } else {
            if (t instanceof Q5Packet) {
                int myPriority = ((Q5Packet) t).getPriority();
                boolean firstIsSmaller = false;
                if (((Q5Packet) current.getData()).getPriority() < myPriority) {
                    node.setNextNode(head);
                    head = node;
                    firstIsSmaller = true;
                }
                while (current.getNextNode() != null) {
                    if (((Q5Packet) current.getNextNode().getData()).getPriority() >= myPriority) {
                        current = current.getNextNode();
                    } else {
                        break;
                    }
                }
                if(!firstIsSmaller){
                    node.setNextNode(current.getNextNode());
                    current.setNextNode(node);
                }
            } else {
                //normal steps
                while (current.getNextNode() != null) {
                    current = current.getNextNode();
                }
                current.setNextNode(node);
            }
        }
    }

    public T peek() {
        if (head == null) {
            return null;
        } else {
            return (T) head.getData();
        }
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("Empty Queue");
        } else {
            Q1ListNode current = head;
            while (current != null) {
                if(current.getData() instanceof Q5Packet){
                    System.out.print(((Q5Packet)current.getData()).index + "-->");
                }else{
                    System.out.print(current.toString());
                }
                current = current.getNextNode();
            }
            System.out.println("");
        }
    }
}
