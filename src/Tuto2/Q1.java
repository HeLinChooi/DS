package Tuto2;

public class Q1 {

    public static <T> void compareOrSum(T e1, T e2) {
        System.out.printf("The paremeters value are : %s and %s\n", e1, e2);
        if(e1 instanceof String){
            String value1 = e1.toString();
            String value2 = e2.toString();
            if(value1.equals(value2)){
                System.out.println("The string is equal");
            }else{
                System.out.println("The string is not equal");
            }
        }else if(e1 instanceof Double){
            double value1 = Double.parseDouble(e1.toString());
            double value2 = Double.parseDouble(e2.toString());
            System.out.println("The sum of the double are : " + (value1+value2));
        }else if (e1 instanceof Integer) {
            int v1 = Integer.parseInt(e1.toString());
            int v2 = Integer.parseInt(e2.toString());
            System.out.println("The sum of the integer is " + (v1+v2));
        }
    }

    public static void main(String[] args) {
        compareOrSum("Hello", "World");
        compareOrSum(12.4, 64.3);
        compareOrSum(20, 35);
        compareOrSum("Hello", "Hello");
    }
}
