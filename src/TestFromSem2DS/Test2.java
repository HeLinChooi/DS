package TestFromSem2DS;

public class Test2 {
    public static void print(int n){
        if(n <= 10){
            System.out.print(n + " ");
            print(n+2);
            System.out.print((n+1)+" ");            
        }
    }
    public static void main(String[] args) {
        print(1);
        Object a = new Object();
        Object b = a;
        if(a==b){
            System.out.println("Same!");
        }
    }
}
