package Bitwise.CountBitwiseOne191;

/**
 * 思路：
 * 比较每位的数，是1就累加
 * 定义一个数进行比较，每次这个数左移1，遍历完所有二进制位32
 */
public class Bitwise_Left {
    public static void main(String[] args) {

    }
    public int hammingWeight(int n) {
        int count = 0;
        int num=1;
        for (int i=0;i<32;i++){
            if ((n&num)!=0){
                count++;
            }
            num<<=1;
        }
        return count;
    }

}
