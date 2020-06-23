package chap1;

public class Desk {
    private static int count=0;
    
    public Desk() {
        count++;
    }
    
    public static int getCount() {
        return count++;
    }
}
