package Lab8;
//He Lin's code

import java.util.Random;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        System.out.print("Enter N Special Random Number within 0-100:");
        int num = s.nextInt();
        Integer[] arr = new Integer[num];
        for (int i = 0; i < num; i++) {
            arr[i] = r.nextInt(101);
        }
        System.out.print("before:");
        showArr(arr);
        weirdMergeSort(arr);
        System.out.print("after :");
        showArr(arr);
    }
    public static void weirdMergeSort(Integer[] arr){
        weirdMergeSort(arr, 0, arr.length-1);
    }
    public static void weirdMergeSort(Integer[] arr,int low,int high){
        if(low<high){
            int mid = (low+high)/2;
            weirdMergeSort(arr, low, mid);
            weirdMergeSort(arr, mid+1, high);
            merge(arr,low,mid,high);
        }
    }
    public static void merge(Integer[] arr,int low,int mid,int high){
        int a1 = mid+1-low;
        int a2 = high - mid;
        Integer[] arr1 = new Integer[a1];
        Integer[] arr2 = new Integer[a2];
        //copy
        for (int i = 0; i < a1; i++) {
            arr1[i] = arr[i+low];
        }
        for (int i = 0; i < a2; i++) {
            arr2[i] = arr[i+mid+1];
        }
        //start arranging
        int index = low;
        int i=0,j=0;
        //this is where the code different from usual mergesort
        while(i<a1 && j<a2){
            if(arr1[i]%2==1 && arr2[j]%2==0){
                arr[index] = arr1[i];
                i++;
            }else if(arr1[i]%2==0 && arr2[j]%2==1){
                arr[index] = arr2[j];
                j++;
            }else{
                if(arr1[i]<arr2[j]){
                    arr[index] = arr1[i];
                    i++;
                }else{
                    arr[index] = arr2[j];
                    j++;
                }
            }
            index++;
        }
        while(i<a1){
            arr[index] = arr1[i];
            i++;
            index++;
        }
        while(j<a2){
            arr[index] = arr2[j];
            j++;
            index++;
        }
    }
    public static void showArr(Integer[] arr){
        System.out.print("Array: ");
        for (Integer elem : arr) {
            System.out.print(elem + " ");
        }
        System.out.println("");
    }
}
