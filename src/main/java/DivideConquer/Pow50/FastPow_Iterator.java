package DivideConquer.Pow50;

public class FastPow_Iterator {
    public static void main(String[] args) {
        new FastPow_Iterator().myPow(3,7);
    }
    public double myPow(double x, int n) {
        double result=1;
        for (int i=n;i!=0;i/=2){
            if (i%2!=0)result*=x;
            x*=x;
        }
        return n>0?result:1/result;
    }


}
