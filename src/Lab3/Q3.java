package Lab3;
//He Lin's code
import java.util.ArrayList;

public class Q3 {
    public static void per(String input){
        per("",input);
    }
    static ArrayList<String> list = new ArrayList<>();
    public static void checker(String str){
        if(!list.contains(str)){
            list.add(str);
            System.out.println(str);
        }
    }
    public static void per(String strToLonger,String original){
        if(original.isEmpty()){
            checker(strToLonger);
            System.out.println("Suppose is "+strToLonger);
        }else{
            for (int i = 0; i < original.length(); i++) {
                String Newper = strToLonger + original.charAt(i);

                String input =  original.substring(0,i) + original.substring(i+1,original.length());
                per(Newper,input);
            }
        }
    }
    public static void main(String[] args) {
        per("101");
    }
}