package Tuto1;

public class Q3 {
    protected String name;
    protected int bandwidth;
    protected int gbUsed;
    public Q3( int bandwidth, int gbUsed) {
        this.bandwidth = bandwidth;
        this.gbUsed = gbUsed;
    }

    public String getName() {
        return name;
    }
    
    public void display(){
        System.out.printf("%dMpbs Subscription and %dGB",bandwidth,gbUsed);
    }
    
}
