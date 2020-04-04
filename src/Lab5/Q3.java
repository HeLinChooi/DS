package Lab5;
//He Lin's code

import java.util.ArrayList;
import java.util.Stack;

public class Q3 {
    //I suggest to have a look at Geeks for Geeks solution,
    //better explanation.
    //this stack only store col num
    static Stack<Integer> stack = new Stack<>();
    static Stack<Integer> tempStack = new Stack<>();
    static ArrayList<Integer> solutions = new ArrayList<>();
    static int solutionsNumber = 0;
    //method to check if queen should put there
    public static boolean isSafe(boolean[][] board,int row,int col){
        int i,j;
        //same col?
        for (i = 0; i < row; i++) {
            if(board[i][col])return false;
        }
        //upper left diagonal 
        for (i = row,j = col; i >=0&&j>=0; i--,j--) {
            if(board[i][j])return false;
        }
        //upper right diagonal
        for (i = row,j=col; i>=0&&j <board.length; i--,j++) {
            if(board[i][j])return false;
        }
        return true;
    }
    //mehtod for backtracking, method from question
    public static void solve(boolean[][] board,int row){
        if(row > board.length-1){
            return;
        }
        //I change the name of current position to current column
        int currentCol = 0;
        while(true){
            //for 1 particular row, we go from col 0 to col N-1
            boolean valid = false;
            for (; currentCol < board.length; currentCol++) {
                if(isSafe(board, row, currentCol)){
//                    System.out.println("push " + currentCol);
                    stack.push(currentCol);
                    board[row][currentCol] = true;
//                    printBoard(board);
                    currentCol=0;
                    valid = true;
                    row++;
                    break;
                }
            }
            if(!valid){
                //base case
                if(stack.isEmpty()){
                        break;
                }else{
                    int rowToBeDeleted = stack.size()-1;
                    int col = stack.pop();
//                    System.out.println(rowToBeDeleted +" " + col);
                    board[rowToBeDeleted][col] = false;
//                    System.out.println("backtrack");
//                    printBoard(board);
                    currentCol = col+1;
                    row--;
                }
            }
            //found a solution, continue searching!
            if(stack.size() == board.length){
//                System.out.println("found solution");
                    solutionsNumber++;
                    printBoardUsingStack(stack.size()-1);
                    //after poping "stack", tempStack holding the "stack" in reverse, push them back
                    while(!tempStack.isEmpty()){stack.push(tempStack.pop());}
                    currentCol = stack.pop();
                    row--;
                    currentCol++;
//                System.out.println("another search,"
//                        + " row = " + row
//                        + " col = " + currentCol);
                //instead of clean the whole board, erase the last element
                for (int j = 0; j < board.length; j++) {
                    if(board[board.length-1][j]){
                        board[board.length-1][j] = false;
                    }
                }
                System.out.println("");
            }
        }
    }
    //method to print board using stack
    public static int printBoardUsingStack(int N){
        if(stack.isEmpty()){return -1;}
        int lastElement = -1;
        int col = -1;
        //recursive
        col = tempStack.push(stack.pop());
        int ret = printBoardUsingStack(N);
        if(ret == -1){
            lastElement = col;
        }else{
            lastElement = ret;
        }
        for (int i = 0; i < col; i++) {
            System.out.print("* ");
        }
        System.out.print("Q ");
        for (int i = col; i < N; i++) {
            System.out.print("* ");
        }
        System.out.println("");
        return lastElement;
    }
    //method to print board
    public static void printBoard(boolean [][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print((board[i][j])?1 + " ":0 + " ");
            }
            System.out.println("");
        }
    }
    //method to initialise N size board
    public static void queens(int n){
        System.out.println("Solving the " + n + " Queens problem");
        boolean[][] board = new boolean[n][n];
        solve(board, 0);
        System.out.println("The number of solutions are : " + solutionsNumber);
    }
    public static void main(String[] args) {
        //decide how many queen you want!
        queens(4);
    }
}
