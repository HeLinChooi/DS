package Lab4;

public class Q7CircularLinkedList<T> {

    Q1ListNode<T> head;
    Q1ListNode<T> tail;
    private int length=0;
    public int length() {
        return length;
    }

    public void addCircularNode(T t) {
        Q1ListNode a = new Q1ListNode(t, null, null);
        if (head == null) {
            head = tail = a;
            length++;
        } else {
            tail.setNextNode(a);
            a.setPreviousNode(tail);
            a.setNextNode(head);
            tail = a;
            length++;
        }
    }

    public void deleterCircularNode() {
        Q1ListNode temp = tail;
        tail = tail.getPreviousNode();
        temp.setPreviousNode(null);
        temp.setNextNode(null);
        tail.setNextNode(head);
        length--;
    }

    public void showCircularList() {
        Q1ListNode current = head;
        for (int i = 0; i < length(); i++) {
            System.out.print(current.getData().toString() + "-->");
            current = current.getNextNode();
        }
        System.out.println(head.getData().toString() + "-->");
    }

    public T getCircularItem(int index) {
        Q1ListNode current = head;
        int count = 0;
        for (int i = 0; i < length(); i++) {
            if (count == index) {
                return (T) current.getData();
            } else {
                current = current.getNextNode();
                count++;
            }
        }
        System.out.println("Item not found.");
        return null;
    }

    public static void main(String[] args) {
        Q7CircularLinkedList<String> a = new Q7CircularLinkedList<>();
        a.addCircularNode("Welcome");
        a.addCircularNode("to");
        a.addCircularNode("FSKTM");
        a.addCircularNode("UM");
        a.showCircularList();
        System.out.println("After deleting a word");
        a.deleterCircularNode();
        a.showCircularList();
    }
}
