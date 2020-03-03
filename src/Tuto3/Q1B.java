package Tuto3;

public class Q1B {

    public static int sum(int[] nums) {
        return sum(nums,-1,0);
    }
    public static int sum(int[] nums,int index,int sum){
        if((index+1)==nums.length){
            return sum;
        }else{
            index++;
            sum += nums[index];
            return sum(nums,index,sum);
        }
    }
    public static void main(String[] args) {
        int[] x = {1,2,3,-1,5,0,6};
        System.out.println("The sum is " + sum(x));
    }
}
