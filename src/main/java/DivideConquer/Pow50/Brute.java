package DivideConquer.Pow50;

/**
 * 思路：
 * n可能是正数，负数，0
 * 标记n--mark，用于最后返回时进行判断。mark是负数用1除结果
 * 迭代：x乘以自身n次
 */
public class Brute {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        int mark = n;
        if (n < 0) {
            n = -n;
        }
        double result = 1;
        for (int i = 0; i < n; i++) {
            result *= x;
        }
        if (mark < 0) return 1 / result;
        return result;
    }
}
