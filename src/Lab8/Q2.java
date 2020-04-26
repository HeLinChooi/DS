package Lab8;
//He Lin's code

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Q2 {
    enum Criteria{
        PRICE,PID;
    }
    public static void main(String[] args) {
        try {
            Scanner s = new Scanner(new FileInputStream("lab8Q2.txt"));
            //get product types amount
            int total = 0;
            while(s.hasNextLine()){
                total++;
                s.nextLine();
            }
            s.close();
            s = new Scanner(new FileInputStream("lab8Q2.txt"));
            Q2Product[] arr = new Q2Product[total];
            String[] temp;
            int index = 0;
            System.out.println("Reading data");
            while(s.hasNextLine()){
                temp = s.nextLine().replaceAll(" ", "").split(",");
                System.out.printf("%s : %s : %s : %s\n"
                ,temp[0],temp[1],temp[2],temp[3]);
                Q2Product t = new Q2Product(temp[0], temp[1], 
                        Double.parseDouble(temp[2]), 
                        Integer.parseInt(temp[3]));
                arr[index] = t;
                index++;
            }
            //sort
            quickSort(arr);
            System.out.println("after sorting");
            showArr(arr);
        } catch (FileNotFoundException ex) {
            System.out.println("FIle not found");
        }
    }
    public static void quickSort(Q2Product[] products){
        quickSort(products,0,products.length-1,Criteria.PRICE);
        quickSortOnPid(products);
    }
    public static void quickSort(Q2Product[] products,int low,int high,Criteria type){
        if (low < high) {
            Q2Product pivot = products[high];
            int i = low - 1;
            for (int j = low; j < high; j++) {
                //compare with pivot
                if(type == Criteria.PRICE){
                    if (products[j].getPrice()<pivot.getPrice()) {
                        //swap
                        i++;
                        Q2Product temp = products[j];
                        products[j] = products[i];
                        products[i] = temp;
                    }
                }else{
                    if (products[j].getPid().compareTo(pivot.getPid())<0) {
                        //swap
                        i++;
                        Q2Product temp = products[j];
                        products[j] = products[i];
                        products[i] = temp;
                    }
                }
            }
            //lastly,swap the pivot
            Q2Product temp = products[i + 1];
            products[i + 1] = products[high];
            products[high] = temp;
            //sort the rest
            quickSort(products, low, i,type);
            quickSort(products, i + 2, high,type);
        }
    }
    public static void quickSortOnPid(Q2Product[] products){
        Q2Product previous = null;
        Q2Product current;
        if(products.length>0){
            previous = products[0];
            int combo = 0;
            int low = 0;
            for (int i = 1; i < products.length; i++) {
                current = products[i];
                if(current.getPrice()==previous.getPrice()){
                    combo++;
                }else{
                    quickSort(products, low, low+combo, Criteria.PID);
                    previous = current;
                    low = i;
                    combo=0;
                }
            }
            if (combo>0) {
                quickSort(products, low, low + combo, Criteria.PID);
            }
        }else{
            System.out.println("arr is empty.");
        }
    }
    public static void showArr(Q2Product[] arr){
        for (Q2Product elem : arr) {
            System.out.printf("%s : %s : %s : %s\n"
                ,elem.getPid(),elem.getSid()
                    ,elem.getPrice(),elem.getQuantity());
        }
    }
}
