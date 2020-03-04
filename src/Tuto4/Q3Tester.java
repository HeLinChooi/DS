package Tuto4;
//He Lin's code
import java.util.Scanner;

public class Q3Tester {
    public static void main(String[] args) {
        Q3LinkedList<Integer> notes = new Q3LinkedList<>();
        notes.addNode(100);
        notes.addNode(50);
        notes.addNode(20);
        notes.addNode(10);
        notes.addNode(5);
        notes.addNode(1);
        Q3LinkedList<Integer> numOfNotes = new Q3LinkedList<>();
        Scanner s = new Scanner(System.in);
        System.out.print("Enter total amount : ");
        int total = s.nextInt();
        numOfNotes.addNode(total/100);
        int fifty = total%100;
        numOfNotes.addNode(fifty/50);
        int twenty = fifty%50;
        numOfNotes.addNode(twenty/20);
        int ten = twenty%20;
        numOfNotes.addNode(ten/10);
        int five = ten%10;
        numOfNotes.addNode(five/5);
        int one = five%5;
        numOfNotes.addNode(one);
        for (int i = 0; i < 6; i++) {
            System.out.println("MYR " + notes.getNodeByPosition(i) + " : " + numOfNotes.getNodeByPosition(i));
        }
    }
}
