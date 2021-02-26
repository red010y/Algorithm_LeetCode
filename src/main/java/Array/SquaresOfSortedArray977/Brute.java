package Array.SquaresOfSortedArray977;

import java.util.Arrays;

/**
 * 思路：
 * 遍历，平方，排序
 */
public class Brute {
    public static void main(String[] args) {
        int arr[]={-4,-1,0,3,10};
        sort(arr);
    }

    private static void sort(int[] arr) {
        for (int i=0;i<arr.length;i++){
            arr[i]*=arr[i];
        }
        Arrays.sort(arr);
    }
}
