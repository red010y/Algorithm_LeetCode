package Array.MinK40;

import java.util.Arrays;
/**
 * 思路：
 * 排序数组，获取k个值
 */
public class Brute {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] result=new int[k];
        //nlogn
        Arrays.sort(arr);
        for (int i=0;i<k;i++){
            result[i]=arr[i];
        }
        return result;
    }
}
