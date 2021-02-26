package Bitwise.CountBitwiseOne191;

/**
 * 思路：
 * 利用x&(x-1)移除最后一个1，记录移除了几次
 */
public class Bitwise {
    public static void main(String[] args) {

    }
    public static int hammingWeight(int x) {
        int count=0;
        while(x!=0){
            x=x&(x-1);
            count++;
        }
        return count;
    }
}
