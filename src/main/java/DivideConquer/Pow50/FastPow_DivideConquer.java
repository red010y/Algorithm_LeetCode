package DivideConquer.Pow50;

/**
 * 思路：
 * 2^10 指数除2分成 2^5 * 2^5 指数相加 2^10
 * 指数如果是奇数 2^5 指数除2分成  2^2 * 2^2 少乘了一位
 * 每次对平方的结果进行平方，到最后的时候判断下n次是否为偶数，非偶数在乘以一个x
 */
public class FastPow_DivideConquer {
    public double myPow(double x, int n) {
        return n > 0 ? divideConquer(x, n) : 1 / divideConquer(x, -n);
    }

    private double divideConquer(double x, int n) {
        if (n == 0) return 1;
        //n/2很有效的避免了堆栈溢出
        double fastPow_val = divideConquer(x, n / 2);
        return n % 2 == 0 ? fastPow_val * fastPow_val : fastPow_val * fastPow_val * x;
    }
}
