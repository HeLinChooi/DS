package Lab2;
//He Lin's code
public class Q2TextFileLog implements Q2SimpleLog {
    private String[] log;
    private int index = -1;
    private int maxSize;
    public Q2TextFileLog(int size) {
        log = new String[size];
        maxSize = size;
    }
    
    public void insert(String s) {
        index++;
        if(isFull()){
            System.out.println("The log is full");
        }else{
            log[index] = s;
        }
    }

    ;
    public boolean isFull(){
        return (index)==(maxSize);
    };

    public int getSize(){
        return index+1;
    };

    public boolean search(String s){
        for (int i = 0; i < maxSize; i++) {
            if(s.equals(log[i])){
                return true;
            }
        }
        return false;
    };

    public void clear(){
        for (int i = 0; i < maxSize; i++) {
            log[i] = null;
        }
        index = -1;
    };

    public void display(){
        for (int i = 0; i < maxSize; i++) {
            System.out.println(log[i]);
        }
    };
}
