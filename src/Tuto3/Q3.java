package Tuto3;

public class Q3 {

    public static void writeLine(char c, int col,int index) {
        if(index == col){
            return ;
        }else{
            index++;
            System.out.print(c);
            writeLine(c,col,index);
        }
    }
    public static void writeLine(char c, int col) {
        writeLine(c, col, 0);
    }
    public static void writeBlock(char c, int col, int row){
        writeBlock(c,col,row,0);
    }
    public static void writeBlock(char c, int col, int row,int index){
        if(index == row){
            return;
        }else{
            index++;
            writeLine(c, col);
            System.out.println("");
            writeBlock(c, col, row,index);
        }
    }
    
    public static void main(String[] args) {
        //writeLine('$', 3);
        writeBlock('$', 3, 2);
    }
}
