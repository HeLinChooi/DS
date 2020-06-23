package Lab9;
//He Lin's code

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Q1 {

    int[][] array;

    public Q1(int dimension) {
        this.array = generateMatrix(dimension);
    }

    private int[][] generateMatrix(int dimension) {
        Random r = new Random();
        int min = 10;
        int max = 19; //not inclusive
        int[][] array = new int[dimension][dimension];
        //print the array as well
        System.out.println("The matrix are :");
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                array[i][j] = r.nextInt(max - min + 1) + min;
                System.out.print(array[i][j] + " ");
            }
            System.out.println("");
        }
        return array;
    }

    public boolean isFound(int element) {
        for (int[] array1 : this.array) {
            for (int j = 0; j < this.array.length; j++) {
                if (array1[j] == element) {
                    System.out.println(element + " is found");
                    return true;
                }
            }
        }
        System.out.println(element + " is not found");
        return false;
    }
    
    public int linearSearchCount(int element){
        int count = 0;
        for (int[] array1 : this.array) {
            for (int j = 0; j < this.array.length; j++) {
                if (array1[j] == element) {
                    count++;
                }
            }
        }
        System.out.printf("The number of %d is %d%n",element,count);
        return count;
    }
    
    public ArrayList linearSearchAllPos(int element){
        ArrayList<String> arrList = new ArrayList<>();
        for (int i = 0; i < this.array.length; i++) {
            for (int j = 0; j < this.array.length; j++) {
                if (this.array[i][j] == element) {
                    arrList.add(i+" "+j);
                }
            }
        }
        return arrList;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter N : ");
        int dimension = s.nextInt();
        System.out.print("Enter a number to search: ");
        int element = s.nextInt();
        Q1 test = new Q1(dimension);
        test.isFound(element);
        test.linearSearchCount(element);
        System.out.println(test.linearSearchAllPos(element));
    }
}
