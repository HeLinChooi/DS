package Tuto3;

public class Q1C {
    //make sure y is > x
    public static int gcd(int x,int y){
        if(y == 0){
            return x;
        }else{
            return gcd(y,x%y);
        }
    }
    public static void main(String[] args) {
        System.out.println("2322 and 654 :" + gcd(2322,654));
    }
}
