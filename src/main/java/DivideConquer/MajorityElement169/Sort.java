package DivideConquer.MajorityElement169;

import java.util.Arrays;

/**
 * 思路：
 * 排序后中间的数就是众数
 */
public class Sort {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    /**
     * 思路：
     * 给数组排序
     * 创建变量count，记录次数
     * 遍历数组，如果count>n/2返回。如果数组的当前元素不等于上一个元素，count归0
     */
    public int majorityElement_stupid(int[] nums) {
        Arrays.sort(nums);
        int count=0;
        for (int i=0;i<nums.length;i++){
            if (i!=0&&nums[i]!=nums[i-1]){
                count=0;
            }
            count++;
            if (count>nums.length/2)return nums[i];
        }
        return -1;
    }
}
