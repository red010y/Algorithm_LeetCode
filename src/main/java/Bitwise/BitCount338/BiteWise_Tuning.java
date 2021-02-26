package Bitwise.BitCount338;

/**
 * 思路：
 * 去除最低位1后的哪个数+1就是我们要的数
 */
public class BiteWise_Tuning {
    public static void main(String[] args) {
        int i=5;
        getArr(i);
    }

    private static int[] getArr(int i) {
        int arr[]=new int[i+1];
        arr[0]=0;
        for (int j=1;j<=i;j++){
            arr[j]=arr[j&(j-1)]+1;
        }
        return arr;
    }
}
