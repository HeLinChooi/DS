package Lab4;

import java.util.LinkedList;

public class Q3Tester {

    public static void main(String[] args) {
        Q2LinkedList<Q3Course> studentA = new Q2LinkedList<>();
        LinkedList<Q3Course> l = new LinkedList<>();
        l.add(new Q3Course("WXX101", "Programming", 5, 'B'));
        studentA.addNode(new Q3Course("WXX101", "Programming", 5, 'B'));
        studentA.addNode(new Q3Course("WXX201", "Networking", 4, 'C'));
        studentA.addNode(new Q3Course("WXX301", "Operating System", 3, 'A'));
        studentA.showList();
        calPointAverage(studentA);
    }

    public static void calPointAverage(Q2LinkedList<Q3Course> l) {
        int points = 0;
        int credits = 0;
        for (int i = 0; i < l.size(); i++) {
            points += getPoint((Q3Course)l.getNodeByPosition(i).getData());
            credits += getCredit((Q3Course)l.getNodeByPosition(i).getData());
        }
        System.out.println("Total point is " + points);
        System.out.println("Total credit is " + credits);
        double ave = points*1.0/credits;
        System.out.printf("Grade point average is %.2f",ave);
    }
    public static int getCredit(Q3Course c){
        return c.getCredit();
    }
    public static int getPoint(Q3Course c) {
        switch (c.getGrade()) {
            case 'A':
                return 4*c.getCredit();
            case 'B':
                return 3*c.getCredit();
            case 'C':
                return 2*c.getCredit();
            case 'D':
                return 1*c.getCredit();
            case 'F':
                return 0*c.getCredit();
            default:
                return -1*c.getCredit();
        }
    }
}
