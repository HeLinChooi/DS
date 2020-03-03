package Tuto3;

public class Q1A {
    
    public static int findMin(int[]nums){
        return findMin(nums,0,nums[0]);
    }
    public static int findMin(int[] nums, int index, int min) {
        if ((index + 1) == nums.length) {
            return min;
        } else {
            index++;
            if (min > nums[index]) {
                min = nums[index];
            }
            return findMin(nums, index, min);
        }
    }
    public static void main(String[] args) {
        int[] x = {-2,2,3,-1,5,0,6};
        System.out.println("The minimum num is " + findMin(x));
    }
}
