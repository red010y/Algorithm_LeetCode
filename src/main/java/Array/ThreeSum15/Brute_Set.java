package Array.ThreeSum15;

import java.util.*;

public class Brute_Set {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();
        //这很重要，直接影响我们的set能否去重
        Arrays.sort(nums);
        for (int i=0;i<nums.length-2;i++){
            for (int j=i+1;j<nums.length-1;j++){
                for (int k=j+1;k<nums.length;k++){
                    if (nums[i]+nums[j]+nums[k]==0){
                        //排序后存放在set中的集合能保证没有重复
                        set.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    //关键是要给result中的list进行排序，这里哪怕不先给数组进行排序，只要给加入result的list进行排序就可以
    public List<List<Integer>> threeSum2(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();
        for (int i=0;i<nums.length-2;i++){
            for (int j=i+1;j<nums.length-1;j++){
                for (int k=j+1;k<nums.length;k++){
                    if (nums[i]+nums[j]+nums[k]==0){
                        //排序后存放在set中的集合能保证没有重复
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(list);
                        set.add(list);
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
}
