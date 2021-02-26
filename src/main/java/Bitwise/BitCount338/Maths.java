package Bitwise.BitCount338;

/**
 * 思路
 * 奇数一定比前面的偶数多一个1
 * 偶数/2和当前偶数的1位个数一样
 */
public class Maths {
    public static void main(String[] args) {
        int x=10;
        get(x);
    }

    private static int[] get(int x) {
        int arr[]=new int[x+1];
        arr[0]=0;
        for (int i=1;i<=x;i++){
            if (i%2==1){
                arr[i]=arr[i-1]+1;
            }else {
                arr[i]=arr[i/2];
            }
        }
        return arr;
    }
}
