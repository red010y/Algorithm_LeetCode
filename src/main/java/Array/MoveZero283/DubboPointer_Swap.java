package Array.MoveZero283;

/**
 * 思路：
 * 记录非0元素的下标
 * 遍历数组，找到非0元素，将元素值互换
 */
public class DubboPointer_Swap {

    //时间复杂度：On
    //空间复杂度：O1
    public static void moveZeroes(int[] nums) {
        int not_zero_index=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=0){
                nums[not_zero_index]=nums[i];
                if (i!=not_zero_index){
                    nums[i]=0;
                }
                not_zero_index++;
            }
        }
    }

    //时间复杂度：On
    //空间复杂度：O1
    //非0位置停在值为0的地方，i不断前进，在非0的时候进行换位
    //最后的结果就是前面是非0数，后面是0
    public static void moveZeroes_2(int[] nums) {
        int not_zero_index=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=0){
                int tmp=nums[not_zero_index];
                nums[not_zero_index++]=nums[i];
                nums[i]=tmp;
            }
        }
    }

    //时间复杂度：On
    //空间复杂度：O1
    //记录0的个数（雪球）
    //如果有雪球，将当前的数变为0，并把之前位置上的雪球赋予当前的值
    public static void moveZeroes_snow(int[] nums) {
        int zero_count=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==0)zero_count++;
            else  if (zero_count>0){
                int tmp=nums[i];
                nums[i]=0;
                nums[i-zero_count]=tmp;
            }
        }
    }

}

