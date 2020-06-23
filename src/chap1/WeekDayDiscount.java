package chap1;

public class WeekDayDiscount extends Discount {       
    private final double rate = 0.3;
    private double sales;

    public WeekDayDiscount(double sales) {
        this.sales = sales;
    }
        
    public double getDiscount() {
        //Weekday discount 30%        
        return (1-rate)*sales;
    }  

    public String toString() {
        return "Normal Price (discount 10%) : " + getNormalDiscount(sales) + 
               "\nWeekday Price (discount 30% : " + getDiscount(); 
    }
}


