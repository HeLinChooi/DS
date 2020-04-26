package Tuto8;
//He Lin's code

import java.util.Random;

public class Q2 {
    public static Random r = new Random();
    public static void showArr(String[] ch){
        System.out.print("Array: ");
        for (int i = 0; i < ch.length; i++) {
            System.out.print(ch[i] + " ");
        }
        System.out.println("");
    }
    public static String generateStr(){
        int numOfChar = 8;
        String ret = "";
        for (int i = 0; i < numOfChar; i++) {
            int temp = r.nextInt(26);
            ret += (char)('a' + temp);
        }
        return ret;
    }
    public static void main(String[] args) {
//        String s = generateStr();
//        System.out.println(s);
        String[] arr = new String[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = generateStr();
        }
        //sort
//        quickSort(arr);
        mergeSort(arr);
        showArr(arr);
    }
    public static void quickSort(String[] s){
        quickSort(s,0,s.length-1);
    }
    public static void quickSort(String[] s,int low,int high){
        if (low < high) {
            String pivot = s[high];
            int i = low - 1;
            for (int j = low; j < high; j++) {
                //compare with pivot
                if (s[j].compareTo(pivot) < 0) {
                    //swap
                    i++;
                    String temp = s[j];
                    s[j] = s[i];
                    s[i] = temp;
                }
            }
            //lastly,swap the pivot
            String temp = s[i + 1];
            s[i + 1] = s[high];
            s[high] = temp;
            //sort the rest
            quickSort(s, low, i);
            quickSort(s, i + 1, high);
        }
    }
   public static void mergeSort(String[] s){
       mergeSort(s,0,s.length-1);
   }
   public static void mergeSort(String[] s,int low,int high){
       if(low<high){
           int mid = (low+high)/2;
           mergeSort(s, low, mid);
           mergeSort(s, mid+1, high);
           merge(s,low,mid,high);
       }
   }
   public static void merge(String[] s,int low,int mid,int high){
       //size of 2 subarray
       int a1 = mid + 1 -low;
       int a2 = high - mid;
       String[] arr1 = new String[a1];
       String[] arr2 = new String[a2];
       //copy from main arr
       for (int i = 0; i < a1; i++) {
           arr1[i] = s[low + i];
       }
       for (int i = 0; i < a2; i++) {
           arr2[i] = s[mid + 1 + i];
       }
       //pointing to bigger array
       int index = low;
       //point to 2 subarray
       int i = 0,j=0;
       while(i<a1 && j<a2){
           if(arr1[i].compareTo(arr2[j])<0){
               s[index] = arr1[i];
               i++;
           }else{
               s[index] = arr2[j];
               j++;
           }
           index++;
       }
       //fill up remaining elements
       while(i<a1){
           s[index] = arr1[i];
           i++;
           index++;
       }
       while(j<a2){
           s[index] = arr2[j];
           j++;
           index++;
       }
   }
}
