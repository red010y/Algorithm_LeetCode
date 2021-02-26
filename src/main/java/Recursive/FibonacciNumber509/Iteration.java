package Recursive.FibonacciNumber509;

public class Iteration {
    public static void main(String[] args) {
        int iteration = iteration(3);
        System.out.println(iteration);
    }

    private static int iteration(int n) {
        int x=0,y=1,result=1;
        if (n<2)return n;
        for(;n>=2;n--){
            result=x+y;
            x=y;
            y=result;
        }
        return result;
    }
}
