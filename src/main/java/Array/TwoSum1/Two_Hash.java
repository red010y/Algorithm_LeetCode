package Array.TwoSum1;

import java.util.HashMap;

/**
 * 思路：
 * 两次hash，先把数据都放到hash，在循环判断
 * 这里巧妙的应用的一点：我们在map中put数据的时候，即使key重复，我们记录的value也是后面的，而我们进行第二次遍历的时候的从前往后去寻找
 *
 * 测试例子：
 *         int arr[]={3,3};
 *         int target=6;
 */
public class Two_Hash {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for (int i=0;i<nums.length;i++){
            int tmp=target-nums[i];
            //必须加条件map.get(tmp)!=i，防止重复使用。比如3,2,4。却出现组合33
            if (map.containsKey(tmp)&&map.get(tmp)!=i){
                result[0]=i;
                result[1]=map.get(tmp);
                return result;
            }
        }
        return result;
    }

}
