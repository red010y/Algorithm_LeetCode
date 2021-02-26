package Recursive.Climbing_stairs70;

/**
 * 思路：
 * 通过观察爬楼梯符合斐波那契数
 * 递归解决
 */
public class Recursive {

    public int climbStairs(int n) {
        return recursive(n);
    }

    private int recursive(int n) {
        if (n<=2)return n;
        return recursive(n-1)+recursive(n-2);
    }

}
