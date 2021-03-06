package Lab4;
//public class Q1LinkedList<T extends Comparable<T>>{
//this is doubly linkedlist

public class Q1LinkedList<T extends Comparable<T>> {

    private Q1ListNode head;

    public Q1LinkedList() {
    }

    public Q1LinkedList(T t) {
        Q1ListNode a = new Q1ListNode(t, null, null);
        head = a;
    }

    public void addNode(T t) {
        Q1ListNode a = new Q1ListNode(t, null, null);
        Q1ListNode currentNode = head;
//        Q1ListNode previousNode = head;
        if (head == null) {
            head = a;
        } else {
            while (currentNode.getNextNode() != null) {
//                previousNode = currentNode;
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(a);
            a.setPreviousNode(currentNode);
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

    public void deleteNode(int index) {
        Q1ListNode temp = head;
        Q1ListNode previousTemp = head;
        int count = 0;
        if (temp == null) {
            System.out.println("The list is empty.");
        }
        while (temp != null) {
            if (index == count) {
                if (temp.getNextNode() != null) {
                    temp.getNextNode().setPreviousNode(previousTemp);
                    previousTemp.setNextNode(temp.getNextNode());
                } else {
                    previousTemp.setNextNode(null);
                }
            } else {
                previousTemp = temp;
                temp = temp.getNextNode();
                count++;
            }
        }
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
        }else{
            head = a;
        }
    }

}
