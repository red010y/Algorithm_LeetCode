package Recursive.FibonacciNumber509;

public class Bad_Recursive {
    public static void main(String[] args) {
        fib(2);
    }

    private static int fib(int n) {
        int x=0,y=1;
        if (n<2)return n;
        if (n==1)return y;
        return fib(n-1)+fib(n-2);
    }
}
