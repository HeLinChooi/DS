package Lab2;
//He Lin's code
import java.util.Random;

public class Q1Tester {
    public static void main(String[] args) {
        Random r = new Random();
        Q1RanArray a = new Q1RanArray();
        
        for (int i = 0; i < 20; i++) {
            a.insert(r.nextInt(101));
        }
        a.sort();
        System.out.println(a.toString());
    }
}
