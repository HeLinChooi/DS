package Lab3;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Q4 {
//1-7 means MOn - Sun

//    public static int day(String str, String search) {
//        String[] searchWord = str.split("/");
//        if (str.equals(search)) {
//            SimpleDateFormat format = new SimpleDateFormat("E");
//            Date dt1 = format.parse(search);
////            DateFormat format2 = new SimpleDateFormat("EEEE");
////            String finalDay = format2.format(dt1);
////            return;
//        }
//    }
    public static int getDay() {
        Date date = new Date();
        SimpleDateFormat f2 = new SimpleDateFormat("E");
        String day = f2.format(date);
        switch (day) {
            case "Mon":
                return 1;
            case "Tue":
                return 2;
            case "Wed":
                return 3;
            case "Thu":
                return 4;
            case "Fri":
                return 5;
            case "Sat":
                return 6;
            case "Sun":
                return 7;
            default:
                return -1;
        }
    }
    public static String getDayName(int index){
        switch (index) {
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            case 7:
                return "Sunday";
            default:
                return "Dooms day";
        }
    }
    static int index = getDay();
    static int diff = 0;

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && !(year % 100 == 0) || year % 400 == 0);
    }

    public static int getNumOfDay(int year, int month) {
        switch (month) {
            case 1:
                return 31;
            case 2:
                if (isLeapYear(year)) {
                    return 29;
                } else {
                    return 28;
                }
            case 3:
                return 31;
            case 4:
                return 30;
            case 5:
                return 31;
            case 6:
                return 30;
            case 7:
                return 31;
            case 8:
                return 31;
            case 9:
                return 30;
            case 10:
                return 31;
            case 11:
                return 30;
            case 12:
                return 31;
            default:
                return -1;
        }
    }

    public static void day(int d, int m, int y, int targetd, int targetm, int targety) {
        if (d == targetd && m == targetm && y == targety) {
            System.out.println("Match!");
            return;
        } else {
//            System.out.printf("hi d:%d m:%d y:%d\n",d,m,y);
            diff++;
            if(d==1){
                if(m==1){
                    day(31, 12, y-1, targetd, targetm, targety);
                }else{
                    d = getNumOfDay(y, m-1);
                    day(d, m-1, y, targetd, targetm, targety);
                }
            }else{
                day(d - 1, m, y, targetd, targetm, targety);
            }
        }
    }
    public static void day(int targetd, int targetm, int targety){
        index = getDay();
        diff = 0;
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("dd");
        int d = Integer.parseInt(f.format(date));
        f = new SimpleDateFormat("MM");
        int m = Integer.parseInt(f.format(date));
        f = new SimpleDateFormat("yyyy");
        int y = Integer.parseInt(f.format(date));
        day(d, m, y, targetd, targetm, targety);
        System.out.println("INdex was " + index);
        System.out.println("diss was " + diff);
        if(index-(diff%7)<=0){
            index = 7 + (index-(diff%7));
        }else{
            index = index-(diff%7);
        }
        System.out.println(getDayName(index));
    }

    public static void main(String[] args) {
        day(26,2,2020);
        day(20,8,2015);
    }
}
