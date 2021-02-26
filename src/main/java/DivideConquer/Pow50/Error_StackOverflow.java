package DivideConquer.Pow50;

/**
 * Exception in thread "main" java.lang.StackOverflowError
 * 	at Test.recursive(Test.java:24)
 * 	at Test.recursive(Test.java:24)
 * 	原因:递归的层数过多，导致线程栈溢出
 *
 * 	思路：
 * 	x递归的乘以自身
 * 	指数是负数就让结果被1除
 */
public class Error_StackOverflow {
    public static void main(String[] args) {
        new Error_StackOverflow().myPow(1.00000
                ,2147483647);
        System.out.println();
    }
    public double myPow(double x, int n) {
        if (n==0)return 1;
        if (n>0) {
            return recursive(1, x, n);
        }else {
            return 1/recursive(1, x, -n);
        }
    }

    private double recursive(double curr, double x, int n) {
        if (n==0)return curr;
        return recursive(curr*x,x,n-1);
    }


    /**
     * Exception in thread "main" java.lang.StackOverflowError
     * 	at Test.recursive(Test.java:24)
     * 	at Test.recursive(Test.java:24)
     * 	原因:递归的层数过多，导致线程栈溢出
     *
     * 	思路：
     * 	x递归的乘以自身
     * 	指数是负数就让结果被1除
     */
    public double myPow3(double x, int n) {
        double result=1;
        if (n<0)return 1/recursive3(result,x,n);
        return recursive3(result,x,n);
    }

    private double recursive3(double result, double x, int n) {
        if (n==0)return 1;
        if (n<0)
            result=recursive3(result,x,n+1);
        else
            result=recursive3(result,x,n-1);
        return result*x;
    }

    //myPow(1.00000, -2147483648);stackOverflow
    public double myPow2(double x, int n) {
        //当n等于-2147483648时转换成正数仍然是-2147483648就会出现死递归
        //因为会超出int范围-2147483648到2147483647
        if (n<0)return 1/myPow2(x,-n);
        if (n == 0) return 1;
        double fastpow_val = myPow2(x, n / 2);
        return n % 2 == 0 ? fastpow_val * fastpow_val : fastpow_val * fastpow_val * x;
    }
}
