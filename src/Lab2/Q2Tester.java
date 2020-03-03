package Lab2;

public class Q2Tester {

    public static void main(String[] args) {
        Q2TextFileLog a = new Q2TextFileLog(5);
        a.insert("James");
        a.insert("James2");
        a.insert("James3");
        a.insert("James4");
        a.insert("James5");
        System.out.println("Text File Log Size " + a.getSize());
        a.display();

        a.insert("James6");
        System.out.println("Search for James:" + a.search("James"));
        a.clear();
        System.out.println("Text File Log Size " + a.getSize());
        
    }
}
