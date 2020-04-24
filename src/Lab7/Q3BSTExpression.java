package Lab7;
//He Lin's code

import java.util.Stack;

public class Q3BSTExpression {
    private Q1BST<Character> a = new Q1BST<>();
    private String exp = "";
    public Q1BST getBST(){return a;}
    public void setExp(String t){
        exp = t.replace(" ", "");
        System.out.println("The number of elements in the tree : "
         + exp.length());
        a = convert(exp);
    }
    public void formBST(Stack ope,Stack bst){
        System.out.println("Form a subtree");
        char operator = (Character)ope.pop();
        Q1BST<Character> newBST = new Q1BST<>();
        newBST.addNode(operator);
//        if(!bst.isEmpty()){
            Q1BST right = (Q1BST)bst.pop();
            newBST.setRightNode(right);
//        }
        if(!bst.isEmpty()){
            Q1BST left = (Q1BST)bst.pop();
            newBST.setLeftNode(left);
        }
        bst.push(newBST);
    }
    public String getExp(){return exp;}
    private Q1BST convert(String exp){
        Q1BST<Character> result;
        Stack<Character> ope = new Stack<>();
        Stack<Q1BST> bst = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            System.out.println("Now " + ch);
            if(ch=='('){
                ope.push(ch);
            }else if(ch==')'){
                char c = ope.peek();
                while(c != '('){
                    formBST(ope, bst);
                    c = ope.peek();
                    if(c == '('){
                        //pop the '(' away
                        System.out.println("you " + ope.pop());
                    }
                }
            }else if(Character.isDigit(ch)){
                System.out.println("it's digit :" + ch);
                Q1BST<Character> temp = new Q1BST<>();
                temp.addNode(ch);
                bst.push(temp);
            }else{
                //it's operator
                if(ope.isEmpty()){
                    ope.push(ch);
                }else{
                    char c = ope.peek();
                    if(getPriority(ch)>=getPriority(c)){
                        ope.push(ch);
                    } else {
                        while (getPriority(ch) < getPriority(c)) {
                            formBST(ope, bst);
                            if(!ope.isEmpty()){c = ope.peek();}
                            else{break;}
                        }
                        ope.push(ch);
                    }
                }
            }
        }
        //after finish reading the expression
        while(!ope.isEmpty()){
            formBST(ope, bst);
        }
        result = bst.pop();
        while(!bst.isEmpty()){System.out.println("left : " + bst.pop());}
        return result;
    }
    public static int getPriority(char c) {
        switch (c) {
            case '*':
            case '/':
            case '%':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return 0;
        }
    }
}
