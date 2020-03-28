package TestFromSem2DS;

import java.util.Arrays;

public class X {

    public static void main(String args[]) {
        String stringArray[] = {"Hello", "how", "are", "you", "welcome", "to", "Tutorialspoint"};
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < stringArray.length; i++) {
            sb.append(stringArray[i]);
        }
        String str = Arrays.toString(stringArray);
        System.out.println(str);
    }
}
