package Lab6;
//He Lin's code

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        //int[] only hv 2 elements, 0 is quatity, 1 is price
        Queue<int[]> shares = new LinkedList<>();
        int gain = 0;
        try {
            //use int[] and queue
            Scanner s= new Scanner(new FileInputStream("lab6Q4.txt"));
            while(s.hasNext()){
                String[] trans = s.nextLine().split(" ");
                String bOrs = "";//B or S?
                if(trans[1].equals("B")){
                    bOrs = "Buy";
                    int[] temp = {Integer.parseInt(trans[2]),Integer.parseInt(trans[3])};
                    shares.add(temp);
                }else if(trans[1].equals("S")){
                    bOrs = "Sell";
                    int sellTotal = 0;
                    int targetSell = Integer.parseInt(trans[2]);
                    while(sellTotal!=targetSell){
                        int[] temp = shares.remove();
                        sellTotal += temp[0];
                        //if exceed the total shares u wanna sell
                        if(sellTotal>targetSell){
                            //only take the amount we need, here we take 30 shares out of 200
                            gain += (temp[0]-(sellTotal-targetSell))*(Integer.parseInt(trans[3])-temp[1]);
                            break;
                        }else{
                            gain += temp[0]*(Integer.parseInt(trans[3])-temp[1]);
                        }
//                        System.out.println("g:" + gain);
                    }
                }
                System.out.printf("Day %d : %s %d shares at RM %d --> \n"
                        ,Integer.parseInt(trans[0])
                        ,bOrs,Integer.parseInt(trans[2])
                        ,Integer.parseInt(trans[3]));
//                System.out.println("Gain:" + gain);
            }
            System.out.println("Total Gain " + gain);
        } catch (FileNotFoundException ex) {
            System.out.println("not found");
        }
    }
}
