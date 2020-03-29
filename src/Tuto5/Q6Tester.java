package Tuto5;

import java.util.Random;

public class Q6Tester {
    public static void alterStack(int[] arr){
        Q1Stack<Integer> a = new Q1Stack<>();
        boolean odd = true;
        o:{
        while(true){
            if(odd){
                int i = 0;
                for (; i < arr.length; i++) {
                    if(arr[i]==0){continue;}
                    if(arr[i]%2==1){
                        a.push(arr[i]);
                        arr[i]=0;
                        odd = false;
                        break;
                    }
                }
                if(i == arr.length){
                    break;
                }
            }else{
                int i = 0;
                for (; i < arr.length; i++) {
                    if(arr[i]==0){continue;}
                    if(arr[i]%2==0){
                        a.push(arr[i]);
                        arr[i]=0;
                        odd = true;
                        break;
                    }
                }
                if(i == arr.length){
                    break;
                }
            }
        }
        }
        System.out.print("stack : ");
        a.showStack();
        System.out.print("Numbers remains in array : ");
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=0){
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        Random r = new Random();
        int[] arr = new int[10];
        System.out.print("The random numbers are ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(100) + 1;
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
        alterStack(arr);
    }
}
