package Tuto2;
public class Q1 {
    public static <T> void compareOrSum(T e1,T e2){
        System.out.printf("The paremeters value are : %s and %s\n",e1,e2);
        //use instanceof method if generic class is requested
        String value1 = e1.toString();
        String[] nums = {"0","1","2","3","4","5","6","7","8","9"};
        for (int i = 0; i < nums.length; i++) {
            if(value1.contains(nums[i])){
                double v1 = Double.parseDouble(value1);
                double v2 = Double.parseDouble(e2.toString());
                if(value1.contains(".")){
                    System.out.printf("The sum of the double is " + (v1+v2) +"\n");
                }else{
                    System.out.println("The sum of the integer is " + (int)(v1+v2));
                }
                //Ask:can I utilise exception by parsing them into int
                return;
            }
        }
        if(value1.equals(e2.toString())){
            System.out.println("The string is equal");
        }else{
            System.out.println("The string is not equal");
        }
    }
    public static void main(String[] args) {
        compareOrSum("Hello", "World");
        compareOrSum(12.4,64.3);
        compareOrSum(20,35);
        compareOrSum("Hello", "Hello");
    }
}
