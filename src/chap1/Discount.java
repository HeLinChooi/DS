
package chap1;

//abstract class
public abstract class Discount {
    private final  double rate = 0.1;
    //concreate method
    public double getNormalDiscount(double sales) {
        //normal discount 10%        
        return (1-rate)*sales;
    }
    
    //abstract method
    public abstract double getDiscount();    
    
}
