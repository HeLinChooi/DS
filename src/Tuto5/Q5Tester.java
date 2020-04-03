package Tuto5;

public class Q5Tester {
    public static void balanceKa(String str){
        Q1Stack<Character> a = new Q1Stack<>();
        char c='*';
        for (int i = 0; i < str.length(); i++) {
             c = str.charAt(i);
            if(c =='('){
                a.push(c);
            }else{
                if(a.pop()==null){
                    System.out.println(str + " is not balanced");
                    return;
                }
            }
        }
        System.out.println(str + " is balanced");
    }
    public static void main(String[] args) {
        balanceKa("(())");
        balanceKa(")()(");
        balanceKa("((())())()");
        balanceKa("(())()))");
        balanceKa("())");
    }
}
