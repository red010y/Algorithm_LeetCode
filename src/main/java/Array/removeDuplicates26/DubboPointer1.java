package Array.removeDuplicates26;

/**
 * 思路：
 * 双指针
 * 一个指向不重复元素位置，一个不断前移
 * 比较两个下标的元素值，不等就进行换位
 */
public class DubboPointer1 {

    public int removeDuplicates(int[] nums) {
        int index=0;
        for (int i=1;i<nums.length;i++){
            if (nums[i]!=nums[index]){
                nums[++index]=nums[i];
            }
        }
        return index+1;
    }


}
