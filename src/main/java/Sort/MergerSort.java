package Sort;

/**
 * 思路：
 * 归并排序
 * 把数组划分为左右两个有序的数组，将这两个数据进行合并
 *
 * 怎么保证的最终有序？我最开始换的就是最小值么？这没法确定啊？是这样的他递归的还会在对第一个位置重新分配。
 */
public class MergerSort {
    public static void main(String[] args) {
        int arr[]={1,234,12,5324,2,8,10,9,11};
        mergesort(arr,0,arr.length-1);
        System.out.println();
    }


    private static void mergesort(int[] nums, int left, int right) {
        if (left>=right)return;
        int mid = (left + right) / 2;
        mergesort(nums,left,mid);
        mergesort(nums,mid+1,right);
        merge(nums,left,mid,right);
    }

    private static void merge(int[] nums, int left, int mid, int right) {
        int i=left,j=mid+1,k=0;
        int[] arr=new int[right-left+1];
        while (i<=mid&&j<=right) {
            if (nums[i] > nums[j]) {
                arr[k++] = nums[j++];
            } else {
                arr[k++] = nums[i++];
            }
        }
        while (i<=mid){
            arr[k++]=nums[i++];
        }
        while (j<=right){
            arr[k++]=nums[j++];
        }
        for (int p=0;p<=right-left;p++){
            nums[left+p]=arr[p];
        }
    }
}
