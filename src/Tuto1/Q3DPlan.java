package Tuto1;

public class Q3DPlan extends Q3{
    int bandwidthRate = 10;
    double dataUsageRate = 0.2;
    public Q3DPlan(int bandwidth, int gbUsed) {
        super(bandwidth, gbUsed);
        name = "DPlan";
    }
    
    public double cal(){
        return this.bandwidth*this.bandwidthRate+this.dataUsageRate*this.gbUsed;
    }
}
