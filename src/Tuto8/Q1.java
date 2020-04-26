package Tuto8;
//He Lin's code

import java.util.Random;

public class Q1 {
//this only handle character
    public static final int MAX = 10;
    public static final int MAXCHAR = 26;
    public static void main(String[] args) {
        Character[] ch = new Character[MAX];
        Random r = new Random();
        for (int i = 0; i < MAX; i++) {
            char ran = (char)(r.nextInt(MAXCHAR) + 'A');
            ch[i] = ran;
        }
        showArr(ch);
        //quick sort
//        quickSort(ch,0,MAX-1);
//        showArr(ch);
        //merge sort
        mergeSort(ch);
        showArr(ch);
        
    }
    public static void showArr(Character[] ch){
        System.out.print("Array: ");
        for (int i = 0; i < ch.length; i++) {
            System.out.print(ch[i] + " ");
        }
        System.out.println("");
    }
    public static void quickSort(Character[] ch,int low,int high){
        if(low < high){
            char pivot = ch[high];
            int i = low-1;
            for (int j = low; j < high; j++) {
                if(ch[j]<pivot){
                    i++;
//                    System.out.println("before");
//                    showArr();
                    char temp = ch[i];
                    ch[i] = (char) ch[j];
                    ch[j] = temp;
//                    System.out.println("after");
//                    showArr();
                }
            }
            //lastly, switch pivot with char at i+1 position
            char temp = ch[i+1];
            ch[i+1] = (char) ch[high];
            ch[high] = temp;
            //continue with smaller char
            quickSort(ch,low, i);
            //continue with larger char
            quickSort(ch,i+2, high);
        }
    }
    public static void mergeSort(Character[] ch){
        mergeSort(ch, 0, ch.length-1);
    }
    private static void mergeSort(Character[] ch,int low,int high){
        if(high>low){
            int mid = (low + high) /2;
            mergeSort(ch, low, mid);
            mergeSort(ch, mid+1, high);
            merge(ch,low,mid,high);
        }
    }
    private static void merge(Character[] ch,int low,int mid,int high){
        //find sizes of 2 subarrays
        int n1 = mid-low+1;
        int n2 = high - mid;
        char[] lowArr = new char[n1];
        char[] highArr = new char[n2];
        //copy
        for (int i = 0; i < n1; i++) {
            lowArr[i] = ch[low+i];
        }
        for (int i = 0; i < n2; i++) {
            highArr[i] = ch[mid+1+i];
        }
        //merge them
        //initial indexes of first and second subarrays
        int i = 0,j = 0;
        //initial index of original array
        int k = low;
        while(i < n1 && j < n2){
            if(lowArr[i]<highArr[j]){
                ch[k] = lowArr[i];
                i++;
            }else{
                ch[k] = highArr[j];
                j++;
            }
            k++;
        }
        //fill up the rest in first subarray if it's not empty
        while(i<n1){
            ch[k] = lowArr[i];
            i++;
            k++;
        }
        //fill up the rest in second subarray if it's not empty
        while(j<n2){
            ch[k] = highArr[j];
            j++;
            k++;
        }
    }
}
