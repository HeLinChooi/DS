package chap3;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class main {
    
    public static void main(String[] args) {
        
        // Example 1
        /*
        int num=1234;
        displayDigit(num);
        System.out.println();
        */
        
        // Example 2
        /*
        String str = "Welcome to FSKTM UM";
        reverse(str, str.length());
        System.out.println();
        */
        // Example 3
        /*
        tower(3, "Source", "Temporary", "Destination");
        */
        // Example 4
        /*
        Random r = new Random();
        int count=0, percentage=33;
        size=10;
        blob = new boolean[size][size];
        int randnum;       
        for(int i=0; i<size; i++)
            for(int j=0; j<size; j++) {
               randnum = r.nextInt(100);
               if (randnum<percentage)
                   blob[i][j] = true;
               else
                   blob[i][j] = false;
           }
        for(int i=0; i<size; i++) {
           for(int j=0; j<size; j++) {
               if (blob[i][j])
                System.out.print("@ ");
               else
                System.out.print("- ");   
           }
           System.out.println();  
       }
       
       // Count Blob
       visited = new boolean[size][size];
       for(int i=0; i<size; i++) 
           for(int j=0; j<size; j++) 
              visited[i][j]=false;    
       
       for(int i=0; i<size; i++) 
           for(int j=0; j<size; j++)  
             if(blob[i][j] && !visited[i][j]) {
                count++;
                markBlob(i,j);
             }   
        System.out.println("Number of blob " + count);  
        */
        
        // Example 5
        /*
        int num=6;
        System.out.println(num + "! = " + factorial(num));
        */
        // Example 6
        /*
        int X=3, Y=4;
        System.out.println(X + " to the power of " + Y + " is " + power(X, Y));
        */
        // Example 7
        /*
        int[] num = {1, 5, 9, 12, 15, 21, 29, 31};         
        System.out.print("The sorted array is : ");  
        for(int i=0; i<num.length; i++) {
            System.out.print(num[i] + " ");  
        }
        Scanner s= new Scanner(System.in);
        System.out.print("\nEnter a number to search : ");  
        int key = s.nextInt();
        int location = binarySearch(num, 0, num.length-1, key);
        if (location==-1) {
            System.out.println(key + " cannot be found");  
        }
        else {
            System.out.println(key + " found in index " + location);  
        }
        */
        // Example 8
        /*
        Scanner s= new Scanner(System.in);
        int num;
        while (true) {
            try {
                System.out.print("Enter an integer : "); 
                num = s.nextInt();
                break;
            } catch(InputMismatchException e) {
                System.out.println("Invalid Input Type"); 
                s.nextLine();
            }
        }
        System.out.println("The integer is " + num); 
        */
        // Example 9
        /*
        String[] str = {"test", "12.34", "56", "A"};
        for(int i=0; i<str.length; i++) {
            checkType(str[i]);
        }
        */
        // Example 10
        /*
        Scanner s= new Scanner(System.in);
        int num;
        while (true) {
            try {
                System.out.print("Enter an integer in between 0 - 20 : ");                 
                num = s.nextInt();
                if (num<0 || num>20) {
                    throw new Exception("The integer must be in between 0 - 20");
                }
                break;
            } catch(InputMismatchException e) {
                System.out.println("Invalid Input Type"); 
                s.nextLine();
            } catch(Exception e) { 
                System.out.println(e.getMessage()); 
            }
        }
        System.out.println("The integer is " + num); 
        */
        // Example 11
        /*
        try {
            ObjectInputStream in = new ObjectInputStream (new FileInputStream("binary.dat"));
            try {
                while(true) {        
                    System.out.print(in.readUTF() + " "); 
                }
            } catch (EOFException e) { }
            System.out.println();
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("File was not found"); 
        } catch (IOException e) {
            System.out.println("Problem with file.");
        }
        */
        // Example 12
        /*
        Scanner s= new Scanner(System.in);
        try {
            System.out.print("Enter a sentence : ");                 
            String str = s.nextLine();
            if (str.equals("")) {
                 throw new EmptyInputException();
            }   
        } catch(Exception e) { 
            System.out.println(e.getMessage()); 
        }
        */
        // Example 13
        /*
        Scanner s= new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter two number : ");                 
                int num1 = s.nextInt();
                int num2 = s.nextInt();
                System.out.println(num1 + " / " + num2 + " = " + divide(num1,num2)); 
                break;
            } catch(ArithmeticException e) { 
                System.out.println(e.getMessage()); 
            }
        }
        */
    }

    public static int divide(int a, int b) throws ArithmeticException {
        return a/b;
    }
    
    public static void checkType(String s) {
        if (isInteger(s)) {
            System.out.println(s + " is an Integer"); 
        }
        else {
            System.out.println(s + " is not an Integer"); 
        }
    }
    
    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s); 
        } catch(NumberFormatException e) {
            return false;
        }
        return true;
    }



    
    public static int binarySearch(int[] a, int first, int last, int key) {
        int index;
        if (first > last)
           return -1; 
        else  { 
           int mid = (first + last)/2;
           if (key == a [mid])
              index = mid; 
           else if (key < a [mid])
              index = binarySearch(a, first, mid-1, key);     
           else
              index = binarySearch(a, mid+1, last, key);
           return index;
        }
    }

    
    
    public static int power(int x, int n) {
        if (n==0) 
            return 1;
        else
            return x*power(x, n-1);
    }

    public static int factorial(int n) {
        if (n==0) 
            return 1;
        else
            return n*factorial(n-1);
    }   

    private static boolean[][] blob, visited;
    private static int size;
    
    public static void markBlob(int row, int col) {
        visited[row][col] = true;
        
        // Check Above
        if((row-1)>=0)
            if(blob[row-1][col]) 
                if (!visited[row-1][col])
                   markBlob(row-1,col);
        
        // Check below
        if((row+1)<size)
            if(blob[row+1][col]) 
                if (!visited[row+1][col])
                   markBlob(row+1,col);
        
        // Check Left
        if((col-1)>=0)
            if(blob[row][col-1]) 
                if (!visited[row][col-1])
                   markBlob(row,col-1);
        
        // Check Right
        if((col+1)<size)
            if(blob[row][col+1]) 
                if (!visited[row][col+1])
                   markBlob(row,col+1);
    }
    
    
    private static String indent = "";
    
    public static void tower(int n, String start, String temp, String end) {
        if (n>0) {
            indent+= "  ";
            System.out.println(indent + "Get " + n + " rings moved from " + start + " to " + end);
            tower(n-1, start, end, temp);
            System.out.println(indent + "Move rings " + n + " from " + start + " to " + end);
            tower(n-1, temp, start, end);
            indent=indent.substring(2);
        }
    }
    
    public static void displayDigit(int n) {
        if (n<10)
            System.out.print(n);
        else {
            displayDigit(n/10);
            System.out.print(n%10);
        }
    }
    
    public static void reverse(String s, int size) {
        if (size==1)
            System.out.print(s.charAt(size-1));
        else {
            System.out.print(s.charAt(size-1));
            reverse(s, --size);
        }
    }
}
