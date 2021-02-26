package BinarySearch.XSqrt69;

/**
 * 思路：
 * y=x^2单调递增函数，有上下界，固使用二分查找
 * 二分，只要mid的平方小于x，就赋值ans，并移动。直到r<l
 */
public class OptimizationBinarySearch {
    public static void main(String[] args) {
        mySqrt(5);
    }
    public static int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
//            防止int越界的一个特殊处理
            int mid =l +(r -l) / 2;
//            int mid =( l + r ) / 2;
            if ((long)mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return ans;
    }

}
