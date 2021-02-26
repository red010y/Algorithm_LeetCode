package Recursive.FibonacciNumber509;

public class Iteration_Arr {
    public static void main(String[] args) {
        fib(3);
    }

    private static int fib(int n) {
        if (n<2)return n;
        int[] arr = new int[n + 1];
        arr[0]=0;
        arr[1]=1;
        for (int i=2;i<=n;i++){
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n];
    }
}
