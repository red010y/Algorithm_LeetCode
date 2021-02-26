package Recursive.FibonacciNumber509;

public class Good_Recursive {
    public static void main(String[] args) {
        fib(3);
    }

    private static int fib(int n) {
        if (n<2)return n;
        return fib(n-1)+fib(n-2);

    }
}
