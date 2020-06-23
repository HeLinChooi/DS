package Lab9;
//He Lin's code

import chap4.ListNode;
import java.util.Random;

public class Q2LinkedList<T extends Comparable<T>> {

    private ListNode head;

    public Q2LinkedList() {
        head = null;
    }

    public int length() {
        int count = 0;
        ListNode currentNode = head;
        while (currentNode != null) {
            currentNode = currentNode.getLink();
            count++;
        }
        return count;
    }

    public void clear() {
        head = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void showList() {
        ListNode currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.toString());
            currentNode = currentNode.getLink();
        }
        System.out.println("");
    }

    // insert at the back
    public void addNode(T a) {
        ListNode newNode = new ListNode(a, null);
        ListNode currentNode = head;
        if (head == null) {
            head = newNode;
        } else {
            while (currentNode.getLink() != null) {
                currentNode = currentNode.getLink();
            }
            currentNode.setLink(newNode);
        }
    }

    // delete from the back
    public void deleteNode() {
        ListNode currentNode = head;
        ListNode previousNode = head;
        if (head != null) {
            if (currentNode.getLink() == null) {
                head = null;
            } else {
                while (currentNode.getLink() != null) {
                    previousNode = currentNode;
                    currentNode = currentNode.getLink();
                }
                previousNode.setLink(null);
            }
        } else {
            System.out.println("The list is empty.");
        }
    }

    public void addFrontNode(T a) {
        head = new ListNode(a, head);
    }

    public void deleteFrontNode() {
        if (head != null) {
            head = head.getLink();
        } else {
            System.out.println("The list is empty.");
        }
    }

    public boolean contains(T t) {
        boolean found = false;
        ListNode currentNode = head;
        while (currentNode != null) {
            if (t.compareTo((T) currentNode.getData()) == 0) {
                found = true;
                break;
            }
            currentNode = currentNode.getLink();
        }
        return found;
    }

    public void addNodeByPosition(T a, int index) {
        if (index == 0) {
            addFrontNode(a);
        } else if (index == length()) {
            addNode(a);
        } else if (index > length()) {
            System.out.println("Invalid index. No node inserted");
        } else {
            ListNode newNode = new ListNode(a, null);
            ListNode currentNode = head;
            for (int i = 1; i < index; i++) {
                currentNode = currentNode.getLink();
            }

            ListNode tempNode = currentNode.getLink();
            currentNode.setLink(newNode);
            newNode.setLink(tempNode);
        }
    }

    public void deleteNodeByPosition(int index) {
        if (index == 0) {
            deleteFrontNode();
        } else if (index == length() - 1) {
            deleteNode();
        } else if (index >= length()) {
            System.out.println("Invalid index. No node deleted");
        } else {
            ListNode currentNode = head;
            for (int i = 1; i < index; i++) {
                currentNode = currentNode.getLink();
            }
            ListNode tempNode = currentNode.getLink();
            currentNode.setLink(tempNode.getLink());
            tempNode = null;
        }
    }

    public void set(T t, int index) {
        if (index == 0) {
            setFront(t);
        } else if (index == length() - 1) {
            setBack(t);
        } else if (index >= length()) {
            System.out.println("Invalid index. Update failed.");
        } else {
            ListNode currentNode = head;
            for (int i = 1; i <= index; i++) {
                currentNode = currentNode.getLink();
            }
            currentNode.setData(t);
        }
    }

    public void setFront(T t) {
        if (head != null) {
            head.setData(t);
        } else {
            System.out.println("Invalid update. List is empty");
        }
    }

    public void setBack(T t) {
        if (head != null) {
            ListNode currentNode = head;
            while (currentNode.getLink() != null) {
                currentNode = currentNode.getLink();
            }
            currentNode.setData(t);
        } else {
            System.out.println("Invalid update. List is empty");
        }
    }

    public T get(int index) {
        if (index == 0) {
            return getFront();
        } else if (index == length() - 1) {
            return getBack();
        } else if (index >= length()) {
            return null;
        } else {
            ListNode currentNode = head;
            for (int i = 1; i <= index; i++) {
                currentNode = currentNode.getLink();
            }
            return (T) currentNode.getData();
        }
    }

    public T getFront() {
        if (head != null) {
            return (T) head.getData();
        } else {
            return null;
        }
    }

    public T getBack() {
        if (head != null) {
            ListNode currentNode = head;
            while (currentNode.getLink() != null) {
                currentNode = currentNode.getLink();
            }
            return (T) currentNode.getData();
        } else {
            return null;
        }
    }
//below is the code added

    public void generateRamdonList(T b, int num) {
        int min = 0;
        int max = 20;
//        if (b instanceof Integer) {
        Random r = new Random();
        for (int i = 0; i < num; i++) {
            this.addNode((T) (Integer) (r.nextInt(max - min + 1) + min));
        }
//        }
    }

    public boolean isFound(T element) {
        ListNode<T> current = this.head;
        while (current != null) {
            if (current.getData().equals(element)) {
                System.out.println(element + " is found");
                return true;
            } else {
                current = current.getLink();
            }
        }
        System.out.println(element + " is not found");
        return false;
    }

    public int linearSearchCount(int element) {
        int count = 0;
        ListNode<T> current = head;
        while (current != null) {
            if (current.getData().equals(element)) {
                count++;
            }
            current = current.getLink();
        }
        System.out.printf("The number of %d is %d%n", element, count);
        return count;
    }

    //by range
    public boolean isFoundByRange(int begin, int end) {
        if (head.getData() instanceof Integer) {
            ListNode<T> current = this.head;
            while (current != null) {
                int currentInt = (Integer) current.getData();
                if (currentInt <= end && currentInt >= begin) {
                    System.out.println("The integer can be found");
                    return true;
                } else {
                    current = current.getLink();
                }
            }
            System.out.println("The integer can not found");
            return false;
        } else {
            System.out.println("The LinkedList in not Integer type");
            return false;
        }
    }

    public boolean linearSearchCountByRange(int begin, int end) {
        if (head.getData() instanceof Integer) {
            int count = 0;
            ListNode<T> current = this.head;
            while (current != null) {
                int currentInt = (Integer) current.getData();
                if (currentInt <= end && currentInt >= begin) {
                    count++;
                }
                current = current.getLink();
            }
            System.out.printf("The number of elements between %d"
                    + " and %d in the data set is %d%n", begin, end,count);
            return false;
        } else {
            System.out.println("The LinkedList in not Integer type");
            return false;
        }
    }
}
