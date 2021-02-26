package BinarySearch.XSqrt69;

/**
 * 思路：
 * 牛顿，猜测一个数是x的平方根，带入公式(guess+x/guess)/2
 * 多迭代几次，一旦等于或者小于了x就说明找到了。
 * guess=(guess+x/guess)/2;
 * g^2=g+x/g
 * 2g^2=g^2+x
 * g^2=x
 * 细节：guess必须是long，避免int越界
 */
public class Newton {
    public static int mySqrt(int x) {
        long guess=0;
        while (guess*guess>x){
            guess=(guess+x/guess)/2;
        }
        return (int) guess;
    }
}

