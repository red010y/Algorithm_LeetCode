package Recursive.Climbing_stairs70;
/**
 * 思路：
 * 通过观察爬楼梯符合斐波那契数
 * 累加的求出第n层有多少策略
 */
public class DP_NoArr {

    public int climbStairs(int n) {
        if(n<=2)return n;
        int fist=1,second=2,result=0;
        for (int i=3;i<=n;i++){
            result=fist+second;
            fist=second;
            second=result;
        }
        return result;
    }

}
