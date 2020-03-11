package Viva1;

import java.util.List;

public interface CardDeck<T> {
    //shuffle the deck
    public void shuffle();
    //draw playing card n times
    public List<T> drawCard(int n);
    //show the deck
    public String toString();
}
