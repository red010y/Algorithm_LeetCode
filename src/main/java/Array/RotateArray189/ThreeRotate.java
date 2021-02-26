package Array.RotateArray189;

/**
 * 思路：
 * 3次反转数组
 * 计算k大于数组长度十，实际移动的值
 * 先整体反转
 * 反转前k个
 * 反转后n-k个
 */
public class ThreeRotate {
    public void rotate(int[] nums, int k) {
        k%=nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (end>start){
            int tmp = nums[start];
            nums[start++]=nums[end];
            nums[end--]=tmp;
        }
    }
}
