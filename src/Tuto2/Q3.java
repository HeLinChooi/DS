package Tuto2;

public class Q3 {

    public static <T extends Comparable<T>> void getMax(T[] t) {
        System.out.print("The meximum value of ");
        if(t[0].toString().contains(".")){
            Double[] dou = new Double[t.length];
            for (int i = 0; i < t.length; i++) {
                dou[i] = Double.parseDouble(t[i].toString());
                System.out.print(dou[i] + " ");
            }
            double max = Double.MIN_VALUE;
            for (Double dou1 : dou) {
                if(max<dou1){
                    max = dou1;
                }
            }
            System.out.println("is " + max);
        }else{
            Integer [] dou = new Integer[t.length];
            for (int i = 0; i < t.length; i++) {
                dou[i] = Integer.parseInt(t[i].toString());
                System.out.print(dou[i] + " ");
            }
            int max = Integer.MIN_VALUE;
            for (Integer dou1 : dou) {
                if(max<dou1){
                    max = dou1;
                }
            }
            System.out.println("is " + max);
        }
    }
    public static void main(String[] args) {
        Integer [] a = {42,15,58};
        Double[] b = {12.45,41.28,19.82};
        getMax(a);
        getMax(b);
        
    }
}
