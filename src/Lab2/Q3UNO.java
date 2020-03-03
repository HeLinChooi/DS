package Lab2;

import java.util.ArrayList;
import java.util.Random;

public class Q3UNO {

    static Random r = new Random();

    public static void generateUNOs() {
        int value = r.nextInt(13);
        //this set without zero
        int value2 = r.nextInt(12);
        ArrayList<String> a = new ArrayList<>();
        int cards = 0;
        //generate numbers with diff colors
        for (int i = 0; i < 4; i++) {
            String color = "";
            switch (i) {
                case 0:
                    color = "Red ";
                    break;
                case 1:
                    color = "Yellow ";
                    break;
                case 2:
                    color = "Blue ";
                    break;
                case 3:
                    color = "Green ";
                    break;
            }
            for (int j = 0; j < 10; j++) {
                a.add(color + j + "");
            }
            for (int j = 1; j < 10; j++) {
                a.add(color + j + "");
            }
            //generate other cards
            for (int j = 0; j < 2; j++) {
                a.add(color + "Skip");
            }
            for (int j = 0; j < 2; j++) {
                a.add(color + "Reverse");
            }
            for (int j = 0; j < 2; j++) {
                a.add(color + "Draw 2");
            }
        }
        for (int j = 0; j < 4; j++) {
            a.add("Draw 4");
        }
        for (int j = 0; j < 4; j++) {
            a.add("Pick Color");
        }
        System.out.println(a);
    }

    public static void main(String[] args) {
        generateUNOs();
    }
}
