package Array.MergeTwoArr88;

/**
 * 思路：
 * 从后往前
 * 利用2个数组都排好序的条件，从nums1的m开始往前遍历，从nums2的n开始往前遍历
 * 比较两个元素，谁大放到nums1的末尾
 * 如果nums2用完，直接结束，nums1就排好序了
 * 如果nums1用完，需要将nums2的元素全放入剩余的位置中
 */
public class DubboPointer_tail {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;
        for (int index = nums1.length - 1; index >= 0; index--) {
            if (m < 0) nums1[index] = nums2[n--];
            else if (n < 0) break;
            else if (nums1[m] > nums2[n]) {
                nums1[index] = nums1[m--];
            } else {
                nums1[index] = nums2[n--];
            }
        }
    }


}
