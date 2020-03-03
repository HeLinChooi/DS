package Tuto4;
//using Q3LinkedList

public class Q4LinkedList<T> {

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

    public int sum() {
        Q3ListNode temp = head;
        int sum = 0;
        int numOfNode = 0;
        while (temp != null) {
            numOfNode++;
            sum += Integer.parseInt(temp.getData().toString());
            temp = temp.getNextNode();
        }
        System.out.println("\nLinked List has " + numOfNode + " node(s)");
        return sum;
    }

    public int numOfEvenNum() {
        Q3ListNode temp = head;
        int total = 0;
        while (temp != null) {
            if (Integer.parseInt(temp.getData().toString()) % 2 == 0) {
                total++;
            }
            temp = temp.getNextNode();
        }
        System.out.print("Total even number is ");
        return total;
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
}
