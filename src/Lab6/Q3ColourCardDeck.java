package Lab6;
//He Lin's code

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Q3ColourCardDeck {
    private ArrayList<String> deck = new ArrayList<>();
    private final static HashMap<String,Integer> COLOURSCORE = new HashMap<>();
    private final static HashMap<String,Integer> NUMSCORE = new HashMap<>();
    static {
        COLOURSCORE.put("Blue", 4);
        COLOURSCORE.put("Green", 3);
        COLOURSCORE.put("Red", 2);
        COLOURSCORE.put("Yellow", 1);
        NUMSCORE.put("One", 1);
        NUMSCORE.put("Two", 2);
        NUMSCORE.put("Three", 3);
        NUMSCORE.put("Four", 4);
        NUMSCORE.put("Five", 5);
        NUMSCORE.put("Six", 6);
        NUMSCORE.put("Seven", 7);
        NUMSCORE.put("Eight", 8);
        NUMSCORE.put("Nine", 9);
        NUMSCORE.put("Ten", 10);
    }
    public Q3ColourCardDeck(){
        String[] colours = {"Blue","Red","Yellow","Green"};
        for (int i = 0; i < 4; i++) {
            String colour = colours[i];
            deck.add("One " + colour);
            deck.add("Two " + colour);
            deck.add("Three " + colour);
            deck.add("Four " + colour);
            deck.add("Five " + colour);
            deck.add("Six " + colour);
            deck.add("Seven " + colour);
            deck.add("Eight " + colour);
            deck.add("Nine " + colour);
            deck.add("Ten " + colour);
        }
       Collections.shuffle(deck);
    }
    public String draw(){
        return deck.remove(0);
    }
    public static boolean winOver(String card1,String card2){
        String[] cardOne = card1.split(" ");
        String[] cardTwo = card2.split(" ");
        if(NUMSCORE.get(cardOne[0])>NUMSCORE.get(cardTwo[0])){
            return true;
        }else if(NUMSCORE.get(cardOne[0])<NUMSCORE.get(cardTwo[0])){
            return false;
        }else{
            if(COLOURSCORE.get(cardOne[1])>COLOURSCORE.get(cardTwo[1])){
                return true;
            }else if(COLOURSCORE.get(cardOne[1])<COLOURSCORE.get(cardTwo[1])){
                return false;
            }else{
                System.out.println("impossible, no 2 card are same.");
                return false;
            }
        }
    }
    public static void main(String[] args) {
        Q3ColourCardDeck d = new Q3ColourCardDeck();
        Queue<String> p1 = new LinkedList<>();
        Queue<String> p2 = new LinkedList<>();
        int p1Score = 0;
        int p2Score = 0;
        //p1 draw
        System.out.println("Player 1");
        for (int i = 0; i < 5; i++) {
            String temp = d.draw();
            System.out.print(temp + " --> ");
            p1.add(temp);
        }
        System.out.println("\nPlayer 2");
        //p2 draw
        for (int i = 0; i < 5; i++) {
            String temp = d.draw();
            System.out.print(temp + " --> ");
            p2.add(temp);
        }
        System.out.println("");
        //compare
        while(!p1.isEmpty()){
            if(winOver(p1.remove(),p2.remove())){
                p1Score++;
            }else{
                p2Score++;
            }
        }
        System.out.println("Player 1 Score : " + p1Score);
        System.out.println("Player 2 Score : " + p2Score);
        if(p1Score>p2Score){
            System.out.println("Player 1 Win!");
        }else if(p1Score<p2Score){
            System.out.println("Player 2 Win!");
        }else{
            System.out.println("Tie!(Impossible if card num is odd)");
        }
    }
}
