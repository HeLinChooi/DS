package Tuto2;
//He Lin's code
public class Q2SpecialEncoding<T> {

    String[] com;

    public Q2SpecialEncoding(T[] t) {
        com = new String[t.length];
        for (int i = 0; i < t.length; i++) {
            com[i] = t[i].toString();
        }
    }

    @Override
    public String toString() {
        StringBuilder x = new StringBuilder();
        x.append("The Code is ");
        for (int i = 0; i < com.length; i++) {
            x.append(com[i] + " ");
        }
        x.append("\nThe command is ");
        for (int i = 0; i < com.length; i++) {
            x.append(getCommand(com[i]) + " ");
        }
//        x.append("\n");
        return new String(x);
    }
    
    
//  what happen if I write thsi
//    public static <T> void getCommand(T t) {

    public String getCommand(String t) {
        if (t.charAt(0) >= 48 && t.charAt(0) <= 57) {
            switch (t) {
                case "0":
                    return "Copy";
                case "1":
                    return "Delete";
                case "2":
                    return "Insert";
                case "3":
                    return "Print";
                case "4":
                    return "Rename";
                case "5":
                    return "Paste";
            }
        }else{
            switch (t) {
                case "C":
                    return "Copy";
                case "D":
                    return "Delete";
                case "I":
                    return "Insert";
                case "P":
                    return "Print";
                case "R":
                    return "Rename";
                case "V":
                    return "Paste";
            }
        }
        return "Error";
    }
    public static void main(String[] args) {
        Integer[] num = {3,2,5,0,1};
        Character[] letter = {'P','I','V','C','D'};
        Q2SpecialEncoding<Integer> a = new Q2SpecialEncoding<>(num);
        Q2SpecialEncoding<Character> b = new Q2SpecialEncoding<>(letter);
        System.out.println(a.toString());
        System.out.println(b.toString());
    }
}
