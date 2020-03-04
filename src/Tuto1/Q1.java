package Tuto1;
//He Lin's code
public class Q1 {
    int day,month,year;

    public Q1(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Day:" + day + " Month: " + month + " Year: " + year
                + "\nDate is : " + String.format("%02d", day) + "/"
                + String.format("%02d", month) + "/" + year;
    }
    public static void main(String[] args) {
        Q1 obj = new Q1(5, 1, 2016);
        System.out.println(obj.toString());
    }
}
