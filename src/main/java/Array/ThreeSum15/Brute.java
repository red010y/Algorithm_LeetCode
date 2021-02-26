package Array.ThreeSum15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 思路：
 * 三层循环，每次循环都进行严格的条件限制
 * 如果当前current的值和current-1的值不同，进行下一步操作，否则continue
 */
public class Brute {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        for (int i=0;i<nums.length;i++){
                if (i>0&&nums[i] == nums[i - 1]) {
                    continue;
                }
            for (int j=i+1;j<nums.length;j++){
                if (j-1!=i&&nums[j] == nums[j - 1]) {
                    continue;
                }
                for (int k=j+1;k<nums.length;k++){
                    if (k-1!=j&&nums[k] == nums[k - 1]) {
                        continue;
                    }
                    if (nums[i]+nums[j]+nums[k]==0){
                        result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    }
                }
            }
        }
        return result;
    }


}
