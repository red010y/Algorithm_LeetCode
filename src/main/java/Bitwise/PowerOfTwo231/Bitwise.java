package Bitwise.PowerOfTwo231;

/**
 * 思路：
 * 利用位运算，找第一个1，如果是2的幂，第一个1就是我们这个数
 * 或者
 * 利用为运算，去除第一个1，如果是2的幂，哪这个数就成为0了
 */
public class Bitwise {
    public static void main(String[] args) {
        int i = 1024;
        Boolean result = bitwise_a(i);
        System.out.println(result);
    }

    private static Boolean bitwise_a(int x) {
        if (x == 0) return false;
//        long x=i;
        return (x & (x - 1)) == 0;
    }
    private static Boolean bitwise_b(int i) {
        if (i == 0) return false;
        long x=i;
        return (x & -x) == x;
    }
}
