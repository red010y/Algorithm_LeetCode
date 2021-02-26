package Array.RotateArray189;


public class Rotate_OneByOne {

    /**
     * 思路：
     * 先让数组整体旋转1次，旋转k次就得到我们要的了
     * 不断的让当前值和最后一个值进行换位。最后的结果就是移动1的结果
     */
    public void rotate(int[] nums, int k) {
        for (int i=0;i<k;i++){
            for (int j=0;j<nums.length-1;j++){
                int tmp=nums[j];
                nums[j]=nums[nums.length-1];
                nums[nums.length-1]=tmp;
            }
        }
    }

    /**
     * 优化版本
     * 思路：
     * 先让数组整体旋转1次，旋转k次就得到我们要的了
     * 记录最后一个元素的值end
     * 不断遍历，每回确定一个位置，改变当前值：把end赋值给当前值，之后当前值赋值给end
     */
    public void rotate2(int[] nums, int k) {
        for (int i=0;i<k;i++){
            int end=nums[nums.length-1];
            for (int j=0;j<nums.length;j++){
                int tmp=nums[j];
                nums[j]=end;
                end=tmp;
            }
        }
    }

}
