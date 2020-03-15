package Tuto2;

public class Q3 {
    public static <T extends Comparable<T>> void getMax(T[] t) {
        System.out.print("The maximum value of ");
        if (t instanceof Integer[]) {
            for (int i = 0; i < t.length; i++) {
                System.out.print(Integer.parseInt(t[i].toString()) + " ");
            }
            int max = Integer.parseInt(t[0].toString());
            if (max < Integer.parseInt(t[1].toString())) {
                max = Integer.parseInt(t[1].toString());
            }
            if (max < Integer.parseInt(t[2].toString())) {
                max = Integer.parseInt(t[2].toString());
            }
            System.out.println("is " + max);
        } else if (t instanceof Double[]) {
            for (int i = 0; i < t.length; i++) {
                System.out.print(Double.parseDouble(t[i].toString()) + " ");
            }
            double max = Double.parseDouble(t[0].toString());
            if (max < Double.parseDouble(t[1].toString())) {
                max = Double.parseDouble(t[1].toString());
            }
            if (max < Double.parseDouble(t[2].toString())) {
                max = Double.parseDouble(t[2].toString());
            }
            System.out.println("is " + max);
        }
    }

    public static void main(String[] args) {
        Integer[] a = {42, 15, 58};
        Double[] b = {12.45, 41.28, 19.82};
        getMax(a);
        getMax(b);

    }
}
