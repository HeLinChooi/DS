package Lab1;

public class Q1 {

    private int hour, min;

    public Q1(int hour, int min) {
        if(check(hour,min)){
            this.hour = hour;
            this.min = min;
            System.out.printf("Hour : %d Minute: %d " + this.toString(),hour,min);
        }else{
            System.out.printf("Hour : %d Minute: %d Invalid time input\n",hour,min);
        }
    }
    
    public boolean check(int hr, int m) {
        return (hr < 24 && hr >= 0 && m < 60 && m >= 0);
    }

    @Override
    public String toString() {
        String zone = (hour<12)?" AM":" PM";
        int h = (hour>12)? hour-12:hour;
        return h + ":" + min + zone + "\n";
    }
    
}
