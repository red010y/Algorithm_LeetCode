package Bitwise.PowerOfTwo231;

/**
 * 思路：
 * 先模以2，判断是不是等于0，是就除以2，直到等于1
 */
public class Maths {
    public static void main(String[] args) {
        int i=1025;
        Boolean result = maths(i);
        System.out.println(result);
    }

    private static Boolean maths(int i) {
        while (i!=1){
            if (i%2==0)i=i/2;
            else return false;
        }
        return true;
    }

    private static Boolean maths_tuning(int i) {
        if (i==0)return false;
        while (i%2==0)i/=2;
        return i==1;
    }
}
