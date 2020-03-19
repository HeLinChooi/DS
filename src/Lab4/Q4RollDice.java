package Lab4;

import java.util.Random;

public class Q4RollDice {

    public static void main(String[] args) {
        Random r = new Random();
        Q2LinkedList<Character> player1 = new Q2LinkedList<>();
        Q2LinkedList<Character> player2 = new Q2LinkedList<>();
        //see who start first
        int who = r.nextInt(2);
        int p1roll = 0;
        int p2roll = 0;
        while (player1.size() < 21 && player2.size() < 21) {
            if (who == 0) {
                System.out.println("Player 1 turn.");
                p1roll = r.nextInt(6) + 1;
                for (int i = 0; i < p1roll; i++) {
                    player1.addNode('.');
                }
                player1.showList();
                who = 1;
            } else {
                System.out.println("Player 2 turn.");
                p2roll = r.nextInt(6) + 1;
                for (int i = 0; i < p2roll; i++) {
                    player2.addNode('.');
                }
                player2.showList();
                who = 0;
            }
        }
        if (player1.size() > 20) {
            System.out.println("Player 1 win");
        } else if (player2.size() > 20) {
            System.out.println("Player 2 win");
        }
    }
}
