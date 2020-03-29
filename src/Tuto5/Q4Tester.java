package Tuto5;

public class Q4Tester {

    public static void fib(int n) {
        if(n<1){
            System.out.println("Invalid input");
            return;
        }
        Q1Stack<Integer> temp = new Q1Stack<>();
        int result = 1;
        int temp1 = 1;
        int temp2 = 1;
        temp.push(temp1);
        temp.push(temp2);
        //whole process stack only hv 2 elements
        for (int i = 2; i < n; i++) {
            //peek after pop
            int second = temp.pop();
            result = second+temp.pop();
            temp.push(second);
            temp.push(result);
        }
        System.out.println("Fib(" + n + "): " + result);
    }

    public static void main(String[] args) {
        fib(1);
        fib(2);
        fib(3);
        fib(4);
        fib(5);
    }
}
