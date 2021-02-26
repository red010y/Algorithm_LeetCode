package Backtrack.Subsets78;

import java.util.ArrayList;
import java.util.List;
/**
 * 思路：
 * 每个数有两个选择，放入格子，或者不放入。
 * 因此结果集的长度是2^n
 * 比如数组1，2，3
 * 有8种可能性，用0表示不放，1表示放。正好可以用1-8的二进制数表示放或不放
 * (res_index >> index) & 1查看当前位是否放元素
 *
 */
public class Bit {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        for (int res_index = 0; res_index < 1 << nums.length; res_index++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int index = 0; index < nums.length; index++) {
                if (((res_index >> index) & 1) == 1) list.add(nums[index]);
            }
            result.add(list);
        }
        return result;
    }
}
