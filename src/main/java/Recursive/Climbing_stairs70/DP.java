package Recursive.Climbing_stairs70;

/**
 * 思路：
 * 通过观察爬楼梯符合斐波那契数
 * 数组存放所有的fib数
 */
public class DP {

    public int climbStairs(int n) {
        if(n<=2)return n;
        int result[]=new int[n];
        result[0]=1;
        result[1]=2;
        for (int i=2;i<n;i++){
            result[i]=result[i-1]+result[i-2];
        }
        return result[n-1];
    }

}
