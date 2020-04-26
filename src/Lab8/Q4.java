package Lab8;
//He Lin's code
public class Q4 {
    //see this link to understand the code
//    https://www.geeksforgeeks.org/heap-sort/
    public static void main(String[] args) {
        int[] a = {6,5,7,13,12,11};
        printArray(a);
        sort(a);
        printArray(a);
    }
    public static void sort(int[] arr){
        int n = arr.length;
        //build heap (rearrange array)
        for (int i = n /2 - 1; i >= 0; i--) {
            maxHeapify(arr, n, i);
        }
        for (int i=n-1; i>0; i--) 
        { 
            // Move current root to end 
            int temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
  
            // call maxHeapify on the reduced heap 
            maxHeapify(arr, i, 0); 
        } 
    }
    public static void maxHeapify(int[] arr,int n,int root){
        int largest = root;
        int l = 2*root + 1;
        int r = 2*root + 2;
        
        if(l < n && arr[l] > arr[largest]){largest = l;}
        if(r < n && arr[r] > arr[largest]){largest = r;}
        if(largest!=root){
            int swap = arr[root];
            arr[root] = arr[largest];
            arr[largest] = swap;
            maxHeapify(arr, n, largest);
        }
    }
    public static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
    } 
}
