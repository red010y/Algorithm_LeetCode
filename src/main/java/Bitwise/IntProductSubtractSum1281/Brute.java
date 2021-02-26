package Bitwise.IntProductSubtractSum1281;

public class Brute {
    public static void main(String[] args) {
        int x=199;
        productSubtractSum(x);
    }

    private static int productSubtractSum(int x) {
        int product=1,sum=0;
        if (x==0)return 0;
        while (x!=0){
            product*=(x%10);
            sum+=(x%10);
            x/=10;
        }
        return product-sum;
    }
}
