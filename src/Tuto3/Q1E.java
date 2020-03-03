package Tuto3;

public class Q1E {

    public static int sumOfCubes(int n) {
        return sumOfCubes(n,0,0);
    }
    public static int sumOfCubes(int n,int index,int sum){
        if(index == n){
            return sum;
        }else{
            index++;
            sum += Math.pow(index, 3);
            return sumOfCubes(n,index,sum);
        }
    }
    public static void main(String[] args) {
        System.out.println(sumOfCubes(3));
    }
}
