package Tuto2;
//He Lin's code

public class Q2SpecialEncoding<T> {

    String[] com;
    private static String[] commands = {"copy","delete","insert","print","rename","paste"};
    T[] temp ;
    public Q2SpecialEncoding(T[] t) {
        temp = t;
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
            x.append(getCommand(temp[i]) + " ");
        }
        return new String(x);
    }


    public static <T> String getCommand(T t) {
        if (t instanceof Integer) {
            switch ((Integer) t) {
                case 0:
                    return commands[0];
                case 1:
                    return commands[1];
                case 2:
                    return commands[2];
                case 3:
                    return commands[3];
                case 4:
                    return commands[4];
                case 5:
                    return commands[5];
                default:
                    return "";
            }
        } else if (t instanceof Character) {
            switch ((Character) t) {
                case 'C':
                    return commands[0];
                case 'D':
                    return commands[1];
                case 'I':
                    return commands[2];
                case 'P':
                    return commands[3];
                case 'R':
                    return commands[4];
                case 'V':
                    return commands[5];
                default:
                    return "";
            }
        }
        return "ERROR";
    }

    public static void main(String[] args) {
        Integer[] num = {3, 2, 5, 0, 1};
        Character[] letter = {'P', 'I', 'V', 'C', 'D'};
        Q2SpecialEncoding<Integer> a = new Q2SpecialEncoding<>(num);
        Q2SpecialEncoding<Character> b = new Q2SpecialEncoding<>(letter);
        System.out.println(a.toString());
        System.out.println(b.toString());
    }
}
