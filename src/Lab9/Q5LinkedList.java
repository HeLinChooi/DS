package Lab9;
//He Lin's code
//this is singly linkedlist

public class Q5LinkedList<K,V> {

    private Q5Node head;

    public Q5LinkedList() {}

    public Q5LinkedList(K k,V v) {
        Q5Node a = new Q5Node(k, v, null);
        head = a;
    }
    public void addNode(K k,V v) {
        Q5Node a = new Q5Node(k, v, null);
        Q5Node currentNode = head;
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
        Q5Node temp = head;
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
        Q5Node temp = head;
        while (temp != null) {
            System.out.print("("+temp.getKey() + " :"
                    + temp.getValue()+")" + " ---> ");
            temp = temp.getNextNode();
        }
        System.out.println("");
    }

    //this method decide which node and nodes after it to show
    public Q5Node searchBasedOnKey(K key){
        Q5Node current = head;
        //check for head only
        if (head.getKey().equals(key)) {
            return head;
        }
        //if it's not head, search the rest
        while (current.getNextNode() != null) {
            current = current.getNextNode();
            if (current.getKey().equals(key)) {
                return current;
            }
        }
        return null;
    }
//    public Q5Node searchBasedOnValue(V value){
//        Q5Node current = head;
//        //check for head only
//        if (head.getValue().equals(value)) {
//            return head;
//        }
//        //if it's not head, search the rest
//        while (current.getNextNode() != null) {
//            current = current.getNextNode();
//            if (current.getValue().equals(value)) {
//                return current;
//            }
//        }
//        return null;
//    }
}

