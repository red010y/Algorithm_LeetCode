package Array.MinK40;

import java.util.Arrays;

/**
 * 思路：
 * 进行快排，如果基数的位置正好是我们要的前k个数的位置，就返回。
 * 如果基数的位置比k大，包含k从l到基数的位置-1.反之
 */
public class QuickSort {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k==0||arr.length==0)return new int[0];
        return sort(arr,0,arr.length-1,k-1);
    }

    private int[] sort(int[] arr, int l, int r, int k) {
        int p=partition(arr,l,r);
        if (p==k){
            return Arrays.copyOf(arr,k+1);
        }
        return p>k?sort(arr,l,p-1,k):sort(arr,p+1,r,k);
    }

    private int partition(int[] arr, int l, int r) {
        int x=arr[l];
        while (r>l){
            while (r>l&&arr[r]>=x){
                r--;
            }
            if (r>l){
                arr[l]=arr[r];
                l++;
            }
            while (r>l&&arr[l]<x){
                l++;
            }
            if (r>l){
                arr[r]=arr[l];
                r--;
            }
        }
        arr[l]=x;
        return l;
    }
}
