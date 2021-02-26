package Array.MergeTwoArr88;

/**
 * 思路：
 * 从前往后
 * 把nums1前m个元素放入新数组nums1_copy
 * 比较nums1_copy和nums2的元素，小的放入nums1
 * 如果nums1_copy的元素用完，就把nums2的元素全拷贝到nums1的剩余位置中。反之亦然
 */
public class DubboPointer_head {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1_copy[]=new int[m];
        System.arraycopy(nums1,0,nums1_copy,0,m);
        int i=0,j=0;
        for (int index=0;index<nums1.length;index++){
            if (i==m) {
                System.arraycopy(nums2, j, nums1, index, n - j);
                break;
            }
            else if (j==n) {
                System.arraycopy(nums1_copy, i, nums1, index, m - i);
                break;
            }
            else if (nums1_copy[i]<nums2[j])nums1[index]=nums1_copy[i++];
            else if (nums1_copy[i]>nums2[j])nums1[index]=nums2[j++];
        }
    }


    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i=0,j=0,index=0;
        int[] arr=new int[m];
        System.arraycopy(nums1,0,arr,0,m);
        while (i!=m&&j!=n){
            if (arr[i]>nums2[j])nums1[index++]=nums2[j++];
            else nums1[index++]=arr[i++];
        }
        for (;index<nums1.length;index++){
            if (i==m)nums1[index]=nums2[j++];
            else if (j==n)nums1[index]=arr[i++];
        }
    }

}
