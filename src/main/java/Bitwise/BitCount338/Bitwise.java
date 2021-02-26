package Bitwise.BitCount338;

/**
 * 思路：
 * 统计范围内每个数，加入到一个数组中，从0开始
 * 统计1个数的方法：x&x-1，执行次数
 */
public class Bitwise {
    public static void main(String[] args) {
        int num=5;
        getArr(num);
    }

    private static int[] getArr(int num) {
        int arr[]=new int[num+1];
        arr[0]=0;
        for (int i=1;i<=num;i++){
            int count = getCount(i);
            arr[i]=count;
        }
        return arr;
    }

    private static int getCount(int i) {
        int count=0;
        while (i!=0){
            i=i&(i-1);
            count++;
        }
        return count;
    }
}
