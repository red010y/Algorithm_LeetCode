package Array.removeDuplicates26;

/**
 * 思路：
 * 双指针
 * 一个记录不重复元素的位置index，一个不断前移
 * 只要nums[n]!=nums[n-1]的就将这个元素放到index
 */
public class DubboPointer2 {
    public int removeDuplicates(int[] nums) {
        int index=1;
        for (int i=1;i<nums.length;i++){
            if (nums[i]!=nums[i-1]){
                nums[index++]=nums[i];
            }
        }
        return index;
    }
}
