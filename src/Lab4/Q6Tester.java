package Lab4;

import java.util.Random;

public class Q6Tester {
    public static void main(String[] args) {
        Q2LinkedList<Integer> l = new Q2LinkedList<>();
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            l.addNode(r.nextInt(101));
        }
        l.showList();
        l.deleteNodebyPosition(2);
        l.showList();
        l.set(6, 999);
        l.showList();
        Q2LinkedList.Q5LinkedListIterator ite = l.iterator();
        while(ite.hasNext()){
            Integer a = (Integer)ite.next();
//            System.out.println("Now number is " + a);
            if(a%2==0){
                ite.remove();
            }
        }
        System.out.println("removing even number...");
        l.showList();
    }
}
