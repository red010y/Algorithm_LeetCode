package Array.TwoSum1;

import java.util.HashMap;

/**
 * 思路：
 * 这里要注意一点，一定要先进行判断，在往map中put
 * 与2次hash相反，这里是存储后面的数，找前面的数
 */
public class One_Hash {

    public int[] twoSum(int[] nums, int target) {
        int[] result=new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            int v=target-nums[i];
            if (map.containsKey(v)){
                result[0]=i;
                result[1]=map.get(v);
            }
            map.put(nums[i],i);
        }
        return result;
    }

}
