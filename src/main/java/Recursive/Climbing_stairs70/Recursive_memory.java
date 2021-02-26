package Recursive.Climbing_stairs70;
/**
 * 思路：
 * 通过观察爬楼梯符合斐波那契数
 * 递归解决
 * 加入记忆数组，如果值在记忆数组中存在直接返回
 */
public class Recursive_memory {
    public int climbStairs(int n) {
        int memory[]=new int[n+1];
        return recursive(memory,n);
    }

    private int recursive(int[] memory, int n) {
        if(n<=2)return n;
        if (memory[n]!=0)return memory[n];
        memory[n]=recursive(memory,n-1)+recursive(memory,n-2);
        return memory[n];
    }
}
