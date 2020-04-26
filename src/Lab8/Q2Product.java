package Lab8;
//He Lin's code
public class Q2Product {
    private String pid;
    private String sid;
    private double price;
    private int quantity;

    public Q2Product(String pid, String sid, double price, int quantity) {
        this.pid = pid;
        this.sid = sid;
        this.price = price;
        this.quantity = quantity;
    }

    public String getPid() {
        return pid;
    }

    public String getSid() {
        return sid;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
    
}
