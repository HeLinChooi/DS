package Viva1D1;

public class Card<E extends Comparable<E>> implements Comparable<Card<E>> {
    //rank is useless, jsut to fulfill question
    E rank;
    String pattern;

    public Card(String pattern) {
        this.pattern = pattern;
    }
    
    @Override
    public String toString() {
        return pattern;
    }

    //for comparing the rank after drawing card
    @Override
    public int compareTo(Card<E> o) {
        int value = getPatternValue(this.pattern)*100 + this.pattern.charAt(7);
        int value2 = getPatternValue(o.pattern)*100 + o.pattern.charAt(7);
        if (value > value2) {
            return 1;
        } else if (value < value2) {
            return -1;
        } else {
            return 0;
        }
    }
    
    private int getPatternValue(String str) {
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
}
