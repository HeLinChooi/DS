package Lab1;

public class Q2Polynomial {
    private int degree;
    private double x;
    private double[] coeInArr;
    
    public Q2Polynomial(int degree, double[] coeInArr) {
        this.degree = degree;
        this.coeInArr = coeInArr;
    }
    public String display(){
        StringBuilder s = new StringBuilder();
        int q = 0;
        int currentDegree = coeInArr.length-1-q;
        while(true){
            if(coeInArr[q]!=0){
                s.append(coeInArr[q]+ "x^" + (coeInArr.length-1-q));
                break;
            }
            q++;
        }
        q++;
        for (int i = q; i <= coeInArr.length-2; i++) {
            if(coeInArr[i]!=0){
                s.append((coeInArr[i]>0)?" +":" ");
                s.append(coeInArr[i]);
                s.append(((coeInArr.length-1-i)>1)?"x^" + (coeInArr.length-1-i):"x");
            }
        }
        s.append(" " + coeInArr[coeInArr.length-1]);
        return new String(s);
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }
    
    public double cal(){
        double ans = 0;
        for (int i = 0; i < coeInArr.length; i++) {
            ans += coeInArr[i]*Math.pow(x, coeInArr.length-1-i);
        }
        return ans;
    }
}
