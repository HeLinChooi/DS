package Lab1;
//He Lin's code
public class Q2Tester {
    public static void main(String[] args) {
        double[] x = {4,2,-0.5,-20};
        Q2Polynomial a = new Q2Polynomial(3, x);
        System.out.println(a.display());
        a.setX(2);
        System.out.println("When x = " + a.getX());
        System.out.println(a.display() + " = " + a.cal());
        a.setX(-3.5);
        System.out.println("When x = " + a.getX());
        System.out.println(a.display() + " = " + a.cal());
    }
}
