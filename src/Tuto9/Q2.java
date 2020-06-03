package Tuto9;
//He Lin's code
public class Q2 {
    public static void main(String[] args) {
        int[] a = {1,2,4,4,5};
        System.out.println(isFound(a, 3));
    }
    public static boolean isFound(int[] arr, int find){
        int low = 0;
        int high = arr.length-1;
        while(low < high){
            System.out.println("ah");
            int mid = (low+high)/2;
            if(arr[mid] == find){
                return true;
            }else if(arr[mid]<find){
                low = mid +1;
            }else if(arr[mid]>find){
                high = mid-1;
            }
        }
        return false;
    }
}
