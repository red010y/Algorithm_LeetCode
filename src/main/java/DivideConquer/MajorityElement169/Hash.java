package DivideConquer.MajorityElement169;

import java.util.HashMap;

/**
 * 思路：
 * map中k存数，v存次数
 * 遍历数组，不断的更新map，如果v>n/2返回
 */
public class Hash {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
            if(map.get(num)>nums.length/2)return num;
        }
        return -1;
    }
}
