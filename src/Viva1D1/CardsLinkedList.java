package Viva1D1;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CardsLinkedList<E>  implements CardDeck<Card> {

     enum P {
        Spade, Heart, Club, Diamond;
    }
    private LinkedList<Card> arrList = new LinkedList<>();
//    HashMap<P, Integer> ranks = new HashMap<>();
    //this var change everytime drawCard method called
    LinkedList<Card> cardOnHand;
    private E type;
    int cardDrewIndex = 0;
    //needed to decide if the type parameter is Integer or Character
    public CardsLinkedList(E type) {
        this.type = type;
    }
    
    //for Integer
    private void intGenerate() {
        P pattern;
        //p will have prestring with length 7
        String p = "";
        for (int i = 0; i < 4; i++) {
            switch (i) {
                case 0:
                    pattern = P.Club;
                    p = "Club   ";
                    break;
                case 1:
                    pattern = P.Diamond;
                    p = "Diamond";
                    break;
                case 2:
                    pattern = P.Heart;
                    p = "Heart  ";
                    break;
                case 3:
                    pattern = P.Spade;
                    p = "Spade  ";
                    break;
            }
            for (int j = 0; j < 10; j++) {
                arrList.add(new Card(p + j));
//                System.out.println(p + j);
            }
        }
    }

    //for Character
    private void charGenerate() {
        P pattern;
        //p will have prestring with length 7
        String p = "";
        for (int i = 0; i < 4; i++) {
            switch (i) {
                case 0:
                    pattern = P.Club;
                    p = "Club   ";
                    break;
                case 1:
                    pattern = P.Diamond;
                    p = "Diamond";
                    break;
                case 2:
                    pattern = P.Heart;
                    p = "Heart  ";
                    break;
                case 3:
                    pattern = P.Spade;
                    p = "Spade  ";
                    break;
            }
            for (int j = 0; j < 26; j++) {
                int k = j + 65;
                char c = (char) k;
                arrList.add(new Card(p + c));
//                System.out.println(p + c);
            }
        }
    }

    @Override
    public void shuffle() {
        if(type instanceof Integer){
            intGenerate();
            System.out.println("It's int");
        }else if (type instanceof Character){
            charGenerate();
            System.out.println("It's char");
        }
        //btw, map each pattern to each rank
        Collections.shuffle(arrList);
    }

    @Override
    public List<Card> drawCard(int n) {
        cardOnHand = new LinkedList<>();
        for (int i = cardDrewIndex; i < n + cardDrewIndex; i++) {
            cardOnHand.add(arrList.get(i));
            //remove the card from deck
            arrList.set(i, new Card(""));
        }
        cardDrewIndex += n;
        return cardOnHand;
    }
    @Override
    public String toString() {
        StringBuilder a = new StringBuilder();
        for (int i = 0; i < cardOnHand.size(); i++) {
            a.append(cardOnHand.get(i) + " ");
        }
        return new String("Cards on hand : " + a);
    }
}
