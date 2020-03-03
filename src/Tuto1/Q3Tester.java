package Tuto1;

public class Q3Tester {
    public static void main(String[] args) {
        Q3DPlan obj1 = new Q3DPlan( 5, 50);
        Q3MPlan obj2 = new Q3MPlan( 5, 50);
        obj1.display();
        System.out.println("");
        System.out.println("Plan : " + obj1.getName() + "with price RM: "
        + obj1.cal());
        System.out.println("Plan : " + obj2.getName() + "with price RM: "
        + obj2.cal());
    }
}
