package Lab7;
//He Lin's code

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Q1BST<String> a = new Q1BST<>();
        try {
            Scanner s  = new Scanner(new FileInputStream("lab7Q2.txt"));
            String line = s.nextLine();
            line = line.replaceAll("[\\.\"\\[\\(\\),]", "");
            String[] words = line.split(" ");
            ArrayList<String> keys = new ArrayList<>();
            for (int i = 0; i < words.length; i++) {
                if(!keys.contains(words[i])){
                    keys.add(words[i].toLowerCase());
                }
                a.addNode(words[i].toLowerCase());
            }
            Collections.sort(keys);
            //start displaying frequency
            HashMap<String,Integer> b = a.freqCounter();
            while(!keys.isEmpty()) {
                String temp = keys.remove(0);
//                System.out.println(b.get("used"));
                System.out.printf("%04d %s -->\n",b.get(temp),temp);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("error");
        }
        
    }
}
