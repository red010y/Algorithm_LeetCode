package Array.MoveZero283;

/**
 * 思路：
 * 记录非0的位置
 * 放好所有的非0元素后，其他的数全部为0
 */
public class DubboPointer_Count {

    //时间复杂度：On
    //空间复杂度：O1
    public void moveZeroes(int[] nums) {
        int not_zero_index=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=0){
                nums[not_zero_index]=nums[i];
                not_zero_index++;
            }
        }
        while (not_zero_index<nums.length){
            nums[not_zero_index++]=0;
        }
    }

    //时间复杂度：On
    //空间复杂度：O1
    public void moveZeroes_2(int[] nums) {
        int not_zero_index=0,count_zero=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=0){
                nums[not_zero_index]=nums[i];
                not_zero_index++;
            }else {
                count_zero++;
            }
        }
        for (int j=0;j<count_zero;j++){
            nums[nums.length-1-j]=0;
        }
    }

}


