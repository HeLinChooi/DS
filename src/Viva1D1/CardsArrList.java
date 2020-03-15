package Viva1D1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class CardsArrList<E> implements CardDeck<Card> {

     enum P {
        Spade, Heart, Club, Diamond;
    }
    private ArrayList<Card> arrList = new ArrayList<>();
    //this var change everytime drawCard method called
    ArrayList<Card> cardOnHand;
    private E type;
    int cardDrewIndex = 0;
    //needed to decide if the type parameter is Integer or Character
    public CardsArrList(E type) {
        this.type = type;
    }
    
    //for Integer
    private void intGenerate() {
        //p will have prestring with length 7
        String p = "";
            for (int j = 0; j < 10; j++) {
                p = "Club   ";
                arrList.add(new Card(p + j));
                p = "Spade  ";
                arrList.add(new Card(p + j));
                p = "Heart  ";
                arrList.add(new Card(p + j));
                p = "Diamond";
                arrList.add(new Card(p + j));
//                System.out.println(p + j);
            }
    }

    //for Character
    private void charGenerate() {
        //p will have prestring with length 7
        String p = "";
            for (int j = 0; j < 26; j++) {
                p = "Spade  ";
                arrList.add(new Card(p + (char) (j+65)));
                p = "Heart  ";
                arrList.add(new Card(p + (char) (j+65)));
                p = "Diamond";
                arrList.add(new Card(p + (char) (j+65)));
                p = "Club   ";
                arrList.add(new Card(p + (char) (j+65)));
//                System.out.println(p + c);
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
        cardOnHand = new ArrayList<>();
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
