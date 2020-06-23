package chap1;

public class FirstDayOfMonthDiscount extends Discount {
    private final  double rate = 0.5;
    private double sales;

    public FirstDayOfMonthDiscount(double sales) {
        this.sales = sales;
    }
        
    public double getDiscount() {
        //Weekday discount 50%        
        return (1-rate)*sales;
    }  

    public String toString() {
        return "Normal Price (discount 10%) : " + getNormalDiscount(sales) + 
               "\nFirst Day of Month Price (discount 50% : " + getDiscount(); 
    }
}
    
