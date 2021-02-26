package DivideConquer.LCOF51;

/**
 * 题目：数组中的逆序对
 * 思路：
 * 归并排序
 * 关键：前面的部分逆序度计算出来后，就可以进行排序了，因为后面的怎么都是其逆序度，所以后面的排序了也不怕影响！75 46
 * 排序后的数组，左到右
 * 划分数组AB两部分，如果只剩下一个数就进行归并
 * 比较大小，将小的放入tmp[]，如果AB有一个用完了，整个放入tmp[]
 * A的元素大于B的元素，统计A后面的元素个数就是当前的逆序度
 * 将值放入原数组
 */
public class MergeSort {

    int result = 0;

    public int reversePairs(int[] nums) {
        int l = 0, r = nums.length - 1;
        mergeSort(nums, l, r);
        return result;
    }

    private void mergeSort(int[] nums, int l, int r) {
        if (l>=r)return;
        int mid = (l + r) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        merge(nums,l,r,mid);
    }

    private void merge(int[] nums, int l, int r, int mid) {
        int i=l,j=mid+1,k=0;
        int tmp[]=new int[r-l+1];
        while (i<=mid&&j<=r){
            if (nums[i]>nums[j]){
                result+=(mid-i+1);
                tmp[k++]=nums[j++];
            }else {
                tmp[k++]=nums[i++];
            }
        }
        while (i<=mid)tmp[k++]=nums[i++];
        while (j<=r)tmp[k++]=nums[j++];
        for (i=0;i<=r-l;i++)nums[l+i]=tmp[i];
    }
}
