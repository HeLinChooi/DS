package Lab4;

public class Q5Tester {
    public static void main(String[] args) {
        Q2LinkedList<String> l = new Q2LinkedList<>();
        l.addNode("ARS");
        l.addNode("CHE");
        l.addNode("LEI");
        l.addNode("MAN");
        l.addNode("LIV");
        l.addNode("TOT");
        Q2LinkedList.Q5LinkedListIterator ite = l.iterator();
        while(ite.hasNext()){
            String a = (String)ite.next();
            if(a.contains("A")){
                ite.remove();
            }
        }
        l.showList();
    }
}
