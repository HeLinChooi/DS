package Tuto4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q1Tester {

    public static void main(String[] args) {
        Q1LinkedList<Double> list = new Q1LinkedList<>();
        list.addNode(23.1);
        list.addNode(36.5);
        list.addNode(12.8);
        list.addNode(42.6);
        list.addNode(32.8);
        list.showList();
        list.moreThan20ThenAdd();
        System.out.println("");
        list.showList();
    }
}
