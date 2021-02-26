package BinarySearch.XSqrt69;

/**
 * 思路：
 * 从0-n组成数组
 * 利用二分查找，找平方等于x的数
 * 如果当前数的平方小于x，该数右侧的平方大于x。则返回小的那个值。
 * 反之，也返回小的。
 */
public class BinarySearch {
    public static void main(String[] args) {
        mySqrt(9);
    }
    public static int mySqrt(int x) {
        if (x==1)return 1;
        long arr[]=new long[x+1];
        for (int i=0;i<=x;i++){
            arr[i]=i;
        }
        int result=search(x,arr);
        return result;
    }

    private static int search(int x, long[] arr) {
        int left=0;
        int right=arr.length-1;
        while (right>=left){
            int mid=(left+right)/2;
            if (arr[mid]*arr[mid]==x)return mid;
            else if (arr[mid]*arr[mid]<x){
                if (arr[mid+1]*arr[mid+1]>x){
                    return mid;
                }
                left=mid+1;
            }else if (arr[mid]*arr[mid]>x){
                if (arr[mid-1]*arr[mid-1]<x){
                    return mid-1;
                }
                right=mid-1;
            }
        }
        return 0;
    }
}
