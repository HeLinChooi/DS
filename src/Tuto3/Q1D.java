package Tuto3;
//He Lin's code
public class Q1D {
    public static void toBinary(int num){
        if(num == 0){
            return;
        }else{
            toBinary(num/2);
            System.out.print(num%2);
        }
    }
    public static void main(String[] args) {
        toBinary(100);
    }
}
