package Viva1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Test {

    private static int getPatternValue(String str) {
        if (str.contains("Spade")) {
            return 3;
        } else if (str.contains("Heart")) {
            return 2;
        } else if (str.contains("Club")) {
            return 1;
        } else {
            // if (str.contains("Diamond"))
            return 0;
        }
    }

    public int getValue(String str) {
        int result = getPatternValue(str);
        result += str.charAt(7);
        return result;
    }

    public static void main(String[] args) {
        //ArrayList Implementation
        //for Integer
        CardsArrList<Integer> deck1 = new CardsArrList<>(0);
        deck1.shuffle();
        ArrayList<Card> player1 = (ArrayList)deck1.drawCard(5);
        System.out.println(deck1.toString());
        ArrayList<Card> player2 = (ArrayList)deck1.drawCard(5);
        System.out.println(deck1.toString());
        Collections.sort(player1);
        System.out.println(player1.get(4).toString());
        Collections.sort(player2);
        System.out.println(player2.get(4).toString());
        String p1Str = player1.get(player1.size() - 1).toString();
        String p2Str = player2.get(player2.size() - 1).toString();
        int p1 = getPatternValue(p1Str)*100 + p1Str.charAt(7);
        int p2 = getPatternValue(p2Str)*100 + p2Str.charAt(7);
        if (p1 > p2) {
            System.out.println("Player 1 Win!");
        } else if (p1 < p2) {
            System.out.println("Player 2 Win!");
        } else {
            System.out.println("Tie!");
        }
        //for Character
        CardsArrList<Character> deck2 = new CardsArrList<>('c');
        deck2.shuffle();
        ArrayList<Card> p3 = (ArrayList)deck2.drawCard(5);
        System.out.println(deck2.toString());
        ArrayList<Card> p4 = (ArrayList)deck2.drawCard(5);
        System.out.println(deck2.toString());
        Collections.sort(p3);
        System.out.println(p3.get(4).toString());
        Collections.sort(p4);
        System.out.println(p4.get(4).toString());
        String p3Str = p3.get(p3.size() - 1).toString();
        String p4Str = p4.get(p4.size() - 1).toString();
        int p3Int = getPatternValue(p3Str)*100 + p3Str.charAt(7);
        int p4Int = getPatternValue(p4Str)*100 + p4Str.charAt(7);
        if (p3Int > p4Int) {
            System.out.println("Player 1 Win!");
        } else if (p3Int < p4Int) {
            System.out.println("Player 2 Win!");
        } else {
            System.out.println("Tie!");
        }
        //now try LinkedList Implementation
        //Character
        CardsLinkedList<Character> deck3 = new CardsLinkedList<>('c');
        deck3.shuffle();
        LinkedList<Card> p5 = (LinkedList)deck3.drawCard(5);
        System.out.println(deck3.toString());
        LinkedList<Card> p6 = (LinkedList)deck3.drawCard(5);
        System.out.println(deck3.toString());
        Collections.sort(p5);
        System.out.println(p5.get(4).toString());
        Collections.sort(p6);
        System.out.println(p6.get(4).toString());
        String p5S = p5.get(p5.size() - 1).toString();
        String p6S = p6.get(p6.size() - 1).toString();
        int p5I = getPatternValue(p5S)*100 + p5S.charAt(7);
        int p6I = getPatternValue(p6S)*100 + p6S.charAt(7);
        if (p5I > p6I) {
            System.out.println("Player 1 Win!");
        } else if (p5I < p6I) {
            System.out.println("Player 2 Win!");
        } else {
            System.out.println("Tie!");
        }
        //Integer
        CardsLinkedList<Integer> deck4 = new CardsLinkedList<>(0);
        deck4.shuffle();
        LinkedList<Card> p7 = (LinkedList)deck4.drawCard(5);
        System.out.println(deck4.toString());
        LinkedList<Card> p8 = (LinkedList)deck4.drawCard(5);
        System.out.println(deck4.toString());
        Collections.sort(p7);
        System.out.println(p7.get(4).toString());
        Collections.sort(p8);
        System.out.println(p8.get(4).toString());
        String p7S = p7.get(p7.size() - 1).toString();
        String p8S = p8.get(p8.size() - 1).toString();
        int p7I = getPatternValue(p7S)*100 + p7S.charAt(7);
        int p8I = getPatternValue(p8S)*100 + p8S.charAt(7);
        if (p7I > p8I) {
            System.out.println("Player 1 Win!");
        } else if (p7I < p8I) {
            System.out.println("Player 2 Win!");
        } else {
            System.out.println("Tie!");
        }
    }

}
