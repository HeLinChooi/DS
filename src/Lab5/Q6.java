package Lab5;
//He Lin's code

import java.util.HashMap;
import java.util.Stack;

public class Q6 {
    static char[][] maze;
    //used for indicating impassable block
    static char[][] mirrorMaze;
    public static void initializeMaze(){
        //size 10 X 20
      maze = new char[][]{{'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'},
                          {'#','S','#',' ',' ',' ',' ',' ',' ',' ','#','F',' ',' ',' ','#',' ',' ',' ','#'},
                          {'#',' ','#','#','#','#','#','#','#',' ','#','#','#','#',' ','#',' ','#',' ','#'},
                          {'#',' ',' ',' ',' ',' ',' ',' ',' ',' ','#',' ',' ','#',' ','#','#','#',' ','#'},
                          {'#','#','#','#','#',' ','#','#','#',' ','#',' ',' ',' ',' ',' ',' ',' ',' ','#'},
                          {'#',' ',' ',' ','#',' ','#',' ',' ',' ','#','#','#','#','#','#','#',' ','#','#'},
                          {'#',' ',' ',' ','#',' ','#',' ','#','#','#',' ','#',' ',' ',' ','#',' ',' ','#'},
                          {'#',' ',' ',' ','#',' ','#',' ','#',' ',' ',' ','#',' ','#',' ','#','#',' ','#'},
                          {'#',' ',' ',' ',' ',' ','#',' ',' ',' ','#',' ',' ',' ','#',' ',' ',' ',' ','#'},
                          {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'}};
      mirrorMaze = new char[][]{{'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'},
                          {'#','S','#',' ',' ',' ',' ',' ',' ',' ','#','F',' ',' ',' ','#',' ',' ',' ','#'},
                          {'#',' ','#','#','#','#','#','#','#',' ','#','#','#','#',' ','#',' ','#',' ','#'},
                          {'#',' ',' ',' ',' ',' ',' ',' ',' ',' ','#',' ',' ','#',' ','#','#','#',' ','#'},
                          {'#','#','#','#','#',' ','#','#','#',' ','#',' ',' ',' ',' ',' ',' ',' ',' ','#'},
                          {'#',' ',' ',' ','#',' ','#',' ',' ',' ','#','#','#','#','#','#','#',' ','#','#'},
                          {'#',' ',' ',' ','#',' ','#',' ','#','#','#',' ','#',' ',' ',' ','#',' ',' ','#'},
                          {'#',' ',' ',' ','#',' ','#',' ','#',' ',' ',' ','#',' ','#',' ','#','#',' ','#'},
                          {'#',' ',' ',' ',' ',' ','#',' ',' ',' ','#',' ',' ',' ','#',' ',' ',' ',' ','#'},
                          {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'}};
    }
    public static Stack reverse(Stack s){
        Stack<Integer> ret = new Stack<>();
        while(!s.isEmpty()){
            ret.push((Integer)s.pop());
        }
        return ret;
    }
    public static void markRoute(Stack temp,int startRow,int startCol){
        Stack<Integer> route = reverse(temp);
        while(!route.isEmpty()){
            int move = (Integer)route.pop();
            if(route.isEmpty()){
                break;
            }
            switch(move){
                case 1:
                    startRow--;
                    break;
                case 2:
                    startCol++;
                    break;
                case 3:
                    startRow++;
                    break;
                case 4:
                    startCol--;
                    break;
            }
//            System.out.println("To success!");
//            printMaze();
            maze[startRow][startCol] = '.';
        }
    }
    public static void findRoute(){
        System.out.println("The original maze is");
        int[] points = printMaze();
        int startX = points[0],startY = points[1];
        int endX = points[2],endY = points[3];
        //this stack store movement
        Stack<Integer> route = new Stack<>();
        //mimic question 3
        //these 2 will be moving around
        int row = startX;
        int col = startY;
//        System.out.println(startX + " " + startY);
        while(true){
//            printMirrorMaze();
            //if this position work, push 1,2,3,4
            //1 = up,2 = right, 3 = down, 4 = left
            if(isSafe(row-1, col)){
//                System.out.println("move up");
                row--;
                route.push(1);
                mirrorMaze[row][col] = '.';
            }else if(isSafe(row, col+1)){
//                System.out.println("move right");
                col++;
                route.push(2);
                mirrorMaze[row][col] = '.';
            }else if(isSafe(row+1, col)){
//                System.out.println("move down");
                row++;
                route.push(3);
                mirrorMaze[row][col] = '.';
            }else if(isSafe(row, col-1)){
//                System.out.println("move left");
                col--;
                route.push(4);
                mirrorMaze[row][col] = '.';
            }else{
            //if no valid move
//                System.out.print("backtrack, ");
                int temp = backtrack(route);
                mirrorMaze[row][col] = '#';
                boolean noSol = false;
                switch(temp){
                    case 1:
//                        System.out.println("move up");
                        row--;
                        break;
                    case 2:
//                        System.out.println("move right");
                        col++;
                        break;
                    case 3:
//                        System.out.println("move down");
                        row++;
                        break;
                    case 4:
//                        System.out.println("move left");
                        col--;
                        break;
                    case -1:
//                        System.out.println("no solution");
                        noSol = true;
                        break;
                }
                if(noSol){break;}
            }
            //if the finish point found
            if(row == endX && col == endY){
                System.out.println("The solution is");
                markRoute(route, startX, startY);
                printMaze();
                break;
            }
        }
    }
    public static int backtrack(Stack s){
        //return new position so the coordinate back to previous posiiton
        //if return 1, y need to plus 1
        //1 = y+1, 2 = x-1, 3 = y-1, 4 = x+1
        int x = (s.isEmpty())?0:(Integer)s.pop();
        //get mirror maze current position
        //first int is x or y
        //1 = x, 2 = y, next int is movement
        switch(x){
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 1;
            case 4:
                return 2;
            default:
                //if the stack is empty, means fail to find solution
                return -1;
        }
    }
    public static boolean isSafe(int x,int y){
//        System.out.println("At row:" + x + " col:" +y);
//        System.out.println("It's " + mirrorMaze[x][y]);
        switch (mirrorMaze[x][y]) {
            case ' ':
                return true;
            case '#':
                return false;
            case 'S':
                return false;
            case '.':
//                System.out.println("explored");
                return false;
            default:
//                System.out.println("Arrived!");
                return true;
        }
    }
    public static int[] printMaze(){
        //return S and F point
        int[] arr = new int[4];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                System.out.print(maze[i][j]);
                if(maze[i][j] == 'S'){
                    arr[0] = i;
                    arr[1] = j;
                }
                if(maze[i][j] == 'F'){
                    arr[2] = i;
                    arr[3] = j;
                }
            }
            System.out.println("");
        }
        return arr;
    }
    public static int[] printMirrorMaze(){
        //return S and F point
        int[] arr = new int[4];
        for (int i = 0; i < mirrorMaze.length; i++) {
            for (int j = 0; j < mirrorMaze[0].length; j++) {
                System.out.print(mirrorMaze[i][j]);
                if(mirrorMaze[i][j] == 'S'){
                    arr[0] = i;
                    arr[1] = j;
                }
                if(mirrorMaze[i][j] == 'F'){
                    arr[2] = i;
                    arr[3] = j;
                }
            }
            System.out.println("");
        }
        return arr;
    }
    public static void main(String[] args) {
        initializeMaze();
        findRoute();
    }
}
