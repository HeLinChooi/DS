package Lab2;
//public class Q1RanArray<T extends Comparable<T>> implements Q1Ran<Integer>{
public class Q1RanArray<T extends Comparable<T>> implements Q1Ran<T>{
    
    private T[] nums;
    private int index = -1;

    public Q1RanArray() {
        nums = (T[])new Integer[21];
    }

    public void insert(T t) {
        //1
//    public void insert(Integer t) {
   
        index++;
//        1
//        Integer o = t;
        nums[index] = t;
    }
    public void sort(){
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                //will this compareTo work?
                if(nums[j].compareTo(nums[j+1]) > 0){
                    T temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }
    public String toString(){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            s.append(nums[i] + " ");
        }
        System.out.println("Array Implementation");
        return new String(s);
    }
}
