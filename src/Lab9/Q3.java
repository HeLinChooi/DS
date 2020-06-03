package Lab9;
//He Lin's code
public class Q3 {
    public static void main(String[] args) {
        Q3ArrayHashTable<String,String> ht = new Q3ArrayHashTable<>();
        ht.put("100-101", "ICND1");
        ht.put("200-101", "ICND2");
        ht.put("200-210", "CCNA Routing and Switching");
        ht.put("210-260", "CCNA Security");
        ht.showHashTable();
        ht.put("300-101", "ROUTE");
        ht.showHashTable();
        ht.put("210-260", "CCNA RS Security");
        ht.showHashTable();
        Q3Node temp = ht.remove("200-101");
        System.out.println(temp.getKey() + " " + temp.getValue() + 
                " removed");
        ht.showHashTable();
        System.out.println("200-101 exist:" + ht.containsKey("200-101"));
        System.out.println("100-101 exist:" + ht.containsKey("100-101"));
    }
}
