package Lab4;
//this is doubly linkedlist
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Q2LinkedList<T> {

    private Q1ListNode head;

    public Q2LinkedList() {
    }

    public Q2LinkedList(T t) {
        Q1ListNode a = new Q1ListNode(t, null, null);
        head = a;
    }

    public void appendList(Q2LinkedList<T> list) {
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

    public void sort() {
        Q1ListNode previous = head;
        Q1ListNode current = head;
        if (head != null) {
//            System.out.println("head is not null");
            if (head.getNextNode() != null) {
                for (int i = 0; i < size(); i++) {
                    previous = head;
                    current = head.getNextNode();
//                    System.out.println("head's next node is not null");
                    for (int j = 0; j < size() - 1; j++) {
                        int previousNum = Integer.parseInt(previous.getData().toString());
                        int currentNum = Integer.parseInt(current.getData().toString());
//                        System.out.println("Pre:" + previousNum + " " + "curr:" + currentNum);
                        if (previousNum > currentNum) {
//                            System.out.println("switch----");
                            if (previous.getPreviousNode() != null) {
                                previous.getPreviousNode().setNextNode(current);
                                current.setPreviousNode(previous.getPreviousNode());
                            } else {
                                current.setPreviousNode(null);
                                head = current;
                            }
                            if (current.getNextNode() != null) {
                                current.getNextNode().setPreviousNode(previous);
                            } else {
                                previous.setNextNode(null);
                            }
                            previous.setNextNode(current.getNextNode());
                            current.setNextNode(previous);
                            previous.setPreviousNode(current);
//                            showList();
                            previous = current.getNextNode();
                            current = current.getNextNode().getNextNode();
                        } else {
                            previous = current;
                            current = current.getNextNode();
//                            System.out.println("No need to switch");
                        }
                    }
                }
            }
        } else {
            System.out.println("The list is empty.");
        }
    }

    public void addSortNode(T t) {
        Q1ListNode a = new Q1ListNode(t, null, null);
        Q1ListNode current = head;
        Q1ListNode previous = head;
        if (head != null) {
            while (true) {
                if (Integer.parseInt(t.toString()) < Integer.parseInt(current.getData().toString())) {
                    if (current.getPreviousNode() != null) {
                        previous.setNextNode(a);
                        a.setPreviousNode(previous);
                        a.setNextNode(current);
                        current.setPreviousNode(a);
                    } else {
                        addNodeAtFront(t);
                    }
                    break;
                } else {
                    previous = current;
                    current = current.getNextNode();
                }
            }
        } else {
            head = a;
        }
    }

    public void splitList(Q2LinkedList l) {
        System.out.println("Split the list into two");
        Q1ListNode previous = head;
        Q1ListNode current = head;
        //after for loop, the current point to new list
        System.out.print("First List : ");
        for (int i = 0; i < size() / 2; i++) {
            previous = current;
            System.out.print(current.getData().toString() + "-->");
            current = current.getNextNode();
        }
        if (size() % 2 == 1) {
            previous = current;
            System.out.print(current.getData().toString() + "-->");
            current = current.getNextNode();
        }
        //cut the links!
        previous.setNextNode(null);
        current.setPreviousNode(null);
        //pass to another list
        l.head = current;
        System.out.print("\nSecond List : ");
        for (int i = 0; i < l.size(); i++) {
            System.out.print(current.getData().toString() + "-->");
            current = current.getNextNode();
        }
    }

    public void alternateList(Q2LinkedList l) {
        System.out.println("Split the list by alternating the nodes");
        int s = this.size();
        for (int i = 1; i < s; i += 2) {
            l.addNode((T) this.getNodeByPosition(i).getData());
            System.out.println("h");
        }
        //the node shift after delete one node, so we delete position
        //1,2,3,4 and so on
        for (int i = 1; i <= s / 2; i++) {
            this.deleteNodebyPosition(i);
            System.out.println("o");
        }
        this.showList();
        l.showList();
    }

    public Q2LinkedList mergeList(Q2LinkedList l) {
        System.out.println("Merge first list and second list by alternating the nodes");
        Q1ListNode currentThis = head;
        Q1ListNode currentThat = l.head;
        Q2LinkedList<T> result = new Q2LinkedList<>();
        while (currentThis != null || currentThat != null) {
            if (currentThis != null) {
                result.addNode((T) currentThis.getData());
                currentThis = currentThis.getNextNode();
            }
            if (currentThat != null) {
                result.addNode((T) currentThat.getData());
                currentThat = currentThat.getNextNode();
            }
        }
        return result;
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
    //return Iterator instance
    public Q5LinkedListIterator<T> iterator(){
        return new Q5LinkedListIterator(this);
    }
    //question 5
    //I USE DIFF TYPE PARAMETER TO DIFFERENTIATE THEM
    class Q5LinkedListIterator<S> implements Iterator<S> {
        //if I write like below, supposed error thrown
//    class Q5LinkedListIterator<T> implements Iterator {

        ArrayList<Integer> a = new ArrayList<>();
        LinkedList<Integer> b = new LinkedList<>();
        
        Q1ListNode<S> current;
        int index = -1;
        //what's the diff of this and the next line?
//        public Q5LinkedListIterator(Q2LinkedList list){
        //my ans: IDE can check the list contain the data type that
        //the above (Q1ListNode<S> current) needed, if no, complilation error thrown
        public Q5LinkedListIterator(Q2LinkedList list){
            current = list.head;
        }
        
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public S next() {
            S data = current.getData();
            current = current.getNextNode();
            index++;
            return data;
        }

        @Override
        public void remove() {
            deleteNodebyPosition(index);
            //actually the node been deleted, need to minus index by 1
            //by next ady pass the control of next Node to current
            //so no prob in next()
            index--;
//            addNode(index, null);
            //comment from gfg
//            Iterator.super.remove(); //To change body of generated methods, choose Tools | Templates.
        }

    }
    //THIS IS ANOTHER VERSION OF ITERATOR CLASS, WITHOUT USING GENERIC
//    public Q5LinkedListIterator iterator(){
//        return new Q5LinkedListIterator(this);
//    }
//    class Q5LinkedListIterator implements Iterator<T> {
//        ArrayList<Integer> a = new ArrayList<>();
//        LinkedList<Integer> b = new LinkedList<>();
//        Q1ListNode<T> current;
//        int index = -1;
//        public Q5LinkedListIterator(Q2LinkedList list){
//            current = list.head;
//        }
//        
//        @Override
//        public boolean hasNext() {
//            return current!=null;
//        }
//        @Override
//        public T next() {
//            T data = current.getData();
//            current = current.getNextNode();
//            index++;
//            return data;
//        }
//        @Override
//        public void remove() {
//            deleteNodebyPosition(index);
//        }
//    }
    //question 6
    public void set(int index,T t){
        Q1ListNode current = head;
        int count = 0;
        while(current!=null){
            if(count==index){
                current.setData(t);
                return;
            }else{
                current = current.getNextNode();
                count++;
            }
        }
    }
}
