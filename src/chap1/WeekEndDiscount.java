package chap1;


public class WeekEndDiscount implements Payment {
    private final double rate = 0.15;
    private double sales, payment;

    public WeekEndDiscount(double sales, double payment) {
        this.sales = sales;
        this.payment = payment;
    }
    
    public double getDiscount() {
        //Weekday discount 15%        
        return (1-rate)*sales;
    }  
    
    public double getBalance() {
        return payment - getDiscount();
    }
    
    public String toString() {
        return "Total Price after 15% discount : " + getDiscount() + 
               "\nTotal Payment : " + payment +
               "\nBalance : " + getBalance(); 
    }   
    
}
