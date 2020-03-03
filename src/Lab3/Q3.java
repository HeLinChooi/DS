package Lab3;

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
    public static void per(String per,String in){
        if(in.isEmpty()){
            checker(per);
            System.out.println("Suppose is "+per);
        }else{
            for (int i = 0; i < in.length(); i++) {
                String Newper = per + in.charAt(i);
//                System.out.println("per become " + per);
                String input =  in.substring(0,i) + in.substring(i+1,in.length());
                per(Newper,input);
            }
        }
    }
//     public static void permutationNoDup(String perm, String num) {
//        if (num.isEmpty()) {
////            checker(perm + num);
//        } else {
//            for (int i = 0; i < num.length(); i++) {
//                String nextPerm = perm + num.charAt(i);
//                String nextNum = num.substring(0, i) + num.substring(i + 1, num.length());
//                permutationNoDup(nextPerm, nextNum);
//            }
//        }
//    }
    public static void main(String[] args) {
        per("101");
    }
////khai's answer
//
//    public static void main(String[] args) {
////        permutation("436");
////        System.out.println("");
////        permutation("5520");
////        System.out.println("");
//        permutationNoDup("5520");
//    }
//
//    public static void permutation(String input) {
//        permutation("", input);
//    }
//
//    public static void permutation(String perm, String num) {
//        if (num.isEmpty()) {
//            System.out.println(perm + num);
//        } else {
//            for (int i = 0; i < num.length(); i++) {
//                permutation(perm + num.charAt(i), num.substring(0, i) + num.substring(i + 1, num.length()));
//            }
//        }
//    }
//    private static String records = " ";
//    
//    public static void checker(String str) {
//        boolean isDup = false;
//        String[] str2 = records.split(" ");
//        for (String list : str2) {
//            System.out.println("This is list:" + list);
//            if (list.equals(str)) {
//                isDup = true;
//                break;
//            }
//        }
//        if (!isDup) {
//            System.out.println("g" + str);
//            records += str + " ";
//        }
//        System.out.println("End of Checker");
//    }
//
//    public static void permutationNoDup(String input) {
//        permutationNoDup("", input);
//    }
//
   
}