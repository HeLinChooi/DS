package Lab1;
//He Lin's code
public class Q3Tester {
    public static void main(String[] args) {
        Q3 a = new Q3("Host 1", "10.1.1.1", "255.255.255.224", true);
        Q3 b = new Q3("Host 2", "10.1.1.2", "255.255.255.224", false);
        Q3 c = new Q3("Host 3", "10.1.1.70", "255.255.255.224", true);
        Q3 d = new Q3("Host 4", "10.1.1.15", "255.255.255.224", true);
        System.out.println(a.Pingable(b));
        System.out.println(a.Pingable(c));
        System.out.println(a.Pingable(d));
    }
}
