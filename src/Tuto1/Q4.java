package Tuto1;

public class Q4 implements Comparable<Q4>{
    private String modelName;
    private int price;

    public Q4(String modelName, int price) {
        this.modelName = modelName;
        this.price = price;
    }

    public String getModelName() {
        return modelName;
    }

    public int getPrice() {
        return price;
    }
    
    @Override
    public int compareTo(Q4 o) {
        if(price == o.price){
            return 0;
        }else 
            if(price> o.price){
            return 1;
        }else{
            return -1;
        }
    }
    
}
