package Lab3;

public class Q1 {

    public static int fac(int n) {
        if(n == 1){
            return 1;
        }else{
            return n*fac(n-1);
        }
    }
    public static int connections(int n){
        return fac(n)/(fac(n-2)*fac(2));
    }
    public static void main(String[] args) {
        System.out.println(fac(3));
        System.out.println(connections(4));
        System.out.println(connections(7));
    }
}
