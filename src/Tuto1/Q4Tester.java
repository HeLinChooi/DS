package Tuto1;

import java.util.ArrayList;
import java.util.Collections;

public class Q4Tester {
    public static void main(String[] args) {
        ArrayList<Q4> phones = new ArrayList<Q4>();
        phones.add(new Q4("iPhone",2400));
        phones.add(new Q4("Samsung",2200));
        phones.add(new Q4("Nokia",1400));
        phones.add(new Q4("LG",1800));
        System.out.println("List of Smart Phone:");
        for (Q4 phone : phones) {
            System.out.printf("%s (RM %d) ",phone.getModelName(),phone.getPrice());
        }
        System.out.println("");
        //sort them
        Collections.sort(phones);
        System.out.println("List of Smart Phone in ascending order of the price:");
        for (Q4 phone : phones) {
            System.out.printf("%s (RM %d) ",phone.getModelName(),phone.getPrice());
        }
    }
}
