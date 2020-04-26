package Tuto8;
//He Lin's code

import Lab4.Q1ListNode;

public class Q3LinkedList<T extends Comparable> {
//this is doubly linkedlist
    private Q1ListNode head;
    public Q3LinkedList() {
    }
    public Q3LinkedList(T t) {
        Q1ListNode a = new Q1ListNode(t, null, null);
        head = a;
    }
    public void appendList(Q3LinkedList<T> list) {
        for (int i = 0; i < list.size(); i++) {
            addNode((T) list.getNodeByPosition(i).getData());
        }
    }
    public void addNode(T t) {
        Q1ListNode a = new Q1ListNode(t, null, null);
        Q1ListNode currentNode = head;
        if (head == null) {
            head = a;
        } else {
            while (currentNode.getNextNode() != null) {
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(a);
            a.setPreviousNode(currentNode);
        }
    }
    public void addNode(int index,T t){
        Q1ListNode a = new Q1ListNode(t, null, null);
        Q1ListNode current = head;
        Q1ListNode previous = head;
        int count = 0;
        while(current!=null){
            if(count == index){
                if(current.equals(head)){
                    head = a;
                    head.setNextNode(current);
                    current.setPreviousNode(head);
                }else{
                    previous.setNextNode(a);
                    a.setPreviousNode(previous);
                    a.setNextNode(current);
                    current.setPreviousNode(a);
                }
            }else{
                previous = current;
                current = current.getNextNode();
                count++;
            }
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
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        Q1ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.getData().toString() + "--->");
            temp = temp.getNextNode();
        }
        System.out.println("");
    }
    //this method decide which node and nodes after it to show
    public void ShowNodeAndAfter(Q1ListNode start) {
        Q1ListNode temp = start;
        while (temp != null) {
            System.out.print(temp.getData().toString() + "-->");
            temp = temp.getNextNode();
        }
        System.out.println("");
    }
    public void addNodeAtFront(T t) {
        Q1ListNode a = new Q1ListNode(t, null, null);
        if (head == null) {
            head = a;
        } else {
            Q1ListNode h = head;
            h.setPreviousNode(a);
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
    public Q1ListNode deleteNodebyPosition(int index) {
        Q1ListNode temp = head;
        Q1ListNode previousTemp = head;
        int count = 0;
        if (temp == null) {
            System.out.println("The list is empty.");
            return null;
        }
        while (temp != null) {
//            System.out.println("hoooooooo");
            if (index == count) {
                if (temp.getNextNode() != null) {
                    if (temp.equals(head)) {
                        head = temp.getNextNode();
                        head.setPreviousNode(null);
                    } else {
                        temp.getNextNode().setPreviousNode(previousTemp);
                        previousTemp.setNextNode(temp.getNextNode());
                    }
                    temp.setPreviousNode(null);
                    temp.setNextNode(null);
                } else {
                    if (temp.equals(head)) {
                        head = null;
                    } else {
                        previousTemp.setNextNode(null);
                        temp.setPreviousNode(null);
                    }
                }
//                System.out.print("data deleted:" + temp.getData().toString());
//                System.out.print(" List become ");
//                showList();
                return temp;
            } else {
                previousTemp = temp;
                temp = temp.getNextNode();
                count++;
            }
        }
        System.out.println("data not found:" + temp.getData().toString());
        return temp;
    }
    public void reverseTheList() {
        reverseTheList(0);
    }
    private void reverseTheList(int pos) {
        if (pos == (size() - 1)) {
//            System.out.println("delete " + deleteNodebyPosition(pos).getData().toString());
            System.out.println(pos);
            addNode((T) deleteNodebyPosition(pos));
        } else {
            reverseTheList(pos + 1);
//            System.out.println("delete " + deleteNodebyPosition(pos).getData().toString());
            System.out.println(pos);
            addNode((T) deleteNodebyPosition(pos));
        }
    }
//Q3 SelectionSort
    public void selectionSort(){
        Q3LinkedList<T> ret = new Q3LinkedList<>();
        Q1ListNode temp;
        T smallest;
        //loop to get the smallest element
        int size = size();
        for (int i = 0; i < size; i++) {
            smallest = (T)head.getData();
            temp = head;
            int index = 0;
            int toBeDeleted = 0;
            while(temp.getNextNode()!=null){
                index++;
                temp = temp.getNextNode();
                if(smallest.compareTo((T)temp.getData())>0){
                    toBeDeleted = index;
                    smallest = (T)temp.getData();
                }
            }
            //got the smallest element now, let's swap!
            deleteNodebyPosition(toBeDeleted);
            ret.addNode(smallest);
        }
        head = ret.head;
    }
//Q4-bubbleSort in descending order
    public void bubbleSort(){
        int size = size();
        Q1ListNode current;
        for (int i = 0; i < size-1; i++) {
            int index = 0;
            current = head;
            while(current.getNextNode()!=null){
//                System.out.println("current:" + current.getData());
                Q1ListNode nextNode = current.getNextNode();
                if(((T)current.getData()).compareTo((T)nextNode.getData())<0){
                    swap(index);
                }else{
                    current = current.getNextNode();
                }
                index++;
            }
        }
    }
    private void swap(int i){
        //swap the element at i with i+1
        if(i<size()-1){
            //move to that node
            Q1ListNode first = head;
            for (int j = 0; j < i; j++) {
                first = first.getNextNode();
            }
            //swap - there is 2 node, previous->first->second->next
            //change links btw them
            Q1ListNode second = first.getNextNode();
            Q1ListNode previous = first.getPreviousNode();
            Q1ListNode next = second.getNextNode();
            //start changing links
            if(previous!=null){
                previous.setNextNode(second);
                second.setPreviousNode(previous);
            }else{
                second.setPreviousNode(null);
            }
            second.setNextNode(first);
            first.setPreviousNode(second);
            if(i==0){
                head = second;
            }
            if (next != null) {
                first.setNextNode(next);
                next.setPreviousNode(first);
            }else{
                //now first is the last element
                first.setNextNode(null);
            }
        }else{
            System.out.println("unable to swap, index out of size");
        }
    } 
}