package Array.ThreeSum15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 思路：
 * 对数组进行排序，方便我们后续找不重复的三元组
 * 我们可以先确定一个数，之后去找后两个数，后面两个数的和是当前确定的数的相反数就可以。
 *
 * 实现：
 * 遍历数组，如果当前的下标是0，或者当前下标i和下一个数i+1不同的情况下进行判断
 * 取下标head和tail，head<tail就循环
 * 如果三数和小于0，就移动head。大于0反之移动tail（因为已经是排序后的数组）
 * 如果等于0就加入result，之后需要移动head和tail，保证他们是一个新的组合（必须两边都移动，因为一旦一边确定，这个组合也就确定了）
 */
public class DubboPointer {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0;i<nums.length-2;i++){
            if (i==0||nums[i]!=nums[i-1]){
                int head=i+1,tail=nums.length-1;
                while (tail>head){
                    if (nums[i]+nums[head]+nums[tail]>0){
                        tail--;
                    }else if (nums[i]+nums[head]+nums[tail]<0){
                        head++;
                    }else {
                        result.add(Arrays.asList(nums[i],nums[head],nums[tail]));
                        while (tail>head&&nums[head]==nums[head+1])head++;
                        while (tail>head&&nums[tail]==nums[tail-1])tail--;
                        head++;
                        tail--;
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum_master(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0;i<nums.length-2;i++){
            if (i==0||nums[i]!=nums[i-1]){
                int head=i+1,tail=nums.length-1;
                while (tail>head){
                    int sum = nums[i] + nums[head] + nums[tail];
                    if (sum>0){
                        while (tail>head&&nums[tail]==nums[--tail]);
                    }else if (sum<0){
                        while (tail>head&&nums[head]==nums[++head]);
                    }else {
                        result.add(Arrays.asList(nums[i],nums[head],nums[tail]));
                        while (tail>head&&nums[head]==nums[++head]);
                        while (tail>head&&nums[tail]==nums[--tail]);
                    }
                }
            }
        }
        return result;
    }
}
