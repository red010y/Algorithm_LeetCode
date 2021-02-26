package Array.MostWater11;

/**
 * 思路：
 * 双指针zero_index指向0，i不断前进
 * 遍历数组，遇到0进行值的换位
 */
public class DubboPointer {

    public void moveZeroes(int[] nums) {
        int zero_index=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=0){
                nums[zero_index]=nums[i];
                if (zero_index!=i)nums[i]=0;
                zero_index++;
            }
        }
    }

}
