package Tuto1;

public class Q3MPlan extends Q3{
    int bandwidthRate = 5;
    double dataUsageRate = 0.8;

    public Q3MPlan(int bandwidth, int gbUsed) {
        super(bandwidth, gbUsed);
        name = "MPlan";
    }
    public double cal(){
        return this.bandwidth*this.bandwidthRate+this.dataUsageRate*this.gbUsed;
    }
}
