package Array.ThreeSum15;
import java.util.*;


/**
 * 思路：
 * 把三数和转换成两数和，遍历数组记录当前值，计算剩下两个数的和target=-current
 * 把剩下的数放入map中，在map中找是否有target-num[j]的值
 * 注意：要在判断map中没有当前差值v的后在进行put操作，相当于记录后面的数，不断的向前找
 * 找到指定的3个数后一定要进行排序，才能进行去重操作

 */
public class Use_Hash {

    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();
        for (int i=0;i<nums.length-2;i++){
            //map必须在这创建么？全局的会怎么样？防止重复使用，例子0-10，本来是没有和为0的组合的，但是map是全局的会检测到0自身，出现000组合
            HashMap<Integer, Integer> map = new HashMap<>();
            int target=-nums[i];
            for (int j=i+1;j<nums.length;j++){
                int v=target-nums[j];
                if (map.containsKey(v)){
                    List<Integer> list = Arrays.asList(nums[i], nums[j], v);
                    Collections.sort(list);
                    set.add(list);
                }else {
                    map.put(nums[j], nums[j]);
                }
            }
        }
        return new ArrayList<>(set);
    }
}
