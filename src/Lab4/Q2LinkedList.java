package Lab4;
//this is doubly linkedlist

public class Q2LinkedList<T extends Comparable<T>> {

    private Q1ListNode head;
    private Q1ListNode head2;
    private Q1ListNode head3;

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
        System.out.println("");
    }

    //this method decide which list to show
    public void chooseListToShow(Q1ListNode start) {
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
        } else {
            head = a;
        }
    }

    public void splitList() {
        System.out.println("Split the list into two");
        if (size() % 2 == 1) {
            Q1ListNode current = head;
            Q1ListNode previous = head;
            //after for loop, the current point to new list
            System.out.print("First List : ");
            for (int i = 0; i <= size() / 2; i++) {
                previous = current;
                System.out.print(current.getData().toString() + "-->");
                current = current.getNextNode();
            }
            current.setPreviousNode(null);
            head2 = current;
            previous.setNextNode(null);
            System.out.print("\nSecond List : ");
            for (int i = 0; i < size() / 2; i++) {
                System.out.print(current.getData().toString() + "-->");
                current = current.getNextNode();
            }
        }
    }

    public void alternateList() {
        System.out.println("Split the list by alternating the nodes");
        Q1ListNode current = head;
        //head2 is null
        Q1ListNode current2 = head2;
        if (current != null) {
            if (current.getNextNode() != null) {
                head2 = current.getNextNode();
                current2 = head2;
                for (int i = 0; i < size() / 2; i++) {
                    current.setNextNode(current2.getNextNode());
                    current = current.getNextNode();
                    if (current.getNextNode() != null) {
                        current2.setNextNode(current.getNextNode());
                        current2 = current2.getNextNode();
                    } else {
                        current2.setNextNode(null);
                    }
                }
                chooseListToShow(head);
                chooseListToShow(head2);
            }
        }
    }

    public void mergeList() {
        System.out.println("Merge first list and second list by alternating the nodes");
        Q1ListNode current;
        Q1ListNode temp = head;
        Q1ListNode temp2 = head2;
        chooseListToShow(temp);
        chooseListToShow(temp2);
        if (temp != null) {
            current = temp;
            temp = temp.getNextNode();
            head3 = current;
            while (temp2 != null) {
                current.setNextNode(temp2);
                temp2 = temp2.getNextNode();
                current = current.getNextNode();
                if (temp != null) {
                    temp.getNextNode();
                    current.setNextNode(temp);
                    current = current.getNextNode();
                    temp = temp.getNextNode();
                }
            }
        }
        chooseListToShow(head3);
    }
}
