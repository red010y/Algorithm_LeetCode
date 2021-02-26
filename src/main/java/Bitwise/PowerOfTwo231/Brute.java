package Bitwise.PowerOfTwo231;

/**
 * 思路：
 * 一直模以2，余数不是0就不是
 * 余数是0，就将该数除以2赋值
 * 一直到这个数变为2
 */
public class Brute {
    public static void main(String[] args) {
        int i=1024;
        Boolean result = powerOfTwo(i);
        System.out.println(result);

    }

    private static Boolean powerOfTwo(int i) {
        while (i!=1){
            if (i%2!=0)return false;
            else {
                i=i/2;
            }
        }
        return true;
    }

}
