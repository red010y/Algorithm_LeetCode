package Array.MergeTwoArr88;

import java.util.Arrays;

/**
 * 思路：
 * 把nums2的元素放入后用Arrays的sort方法排序
 */
public class Brute {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index=0;
        for (int i=m;m<nums1.length;m++){
            nums1[m]=nums2[index++];
        }
        Arrays.sort(nums1);
    }


    /**
     * src - 源数组。
     * srcPos - 源数组中的起始位置。
     * dest - 目标数组。
     * destPos - 目标数据中的起始位置。
     * length - 要复制的数组元素的数量。
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2,0,nums1,m,n);
        Arrays.sort(nums1);
    }
}
