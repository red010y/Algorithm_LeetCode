package Backtrack.Subsets78;

import java.util.ArrayList;
import java.util.List;

/**
 * 思路：
 * 每增加一个元素让之前所有的结果集中加入这个元素
 */
public class Iterator {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<>());
        for (int num:nums){
            int size = res.size();
            for (int i=0;i<size;i++){
                ArrayList<Integer> list = new ArrayList<>(res.get(i));
                list.add(num);
                res.add(list);
            }
        }
        return res;
    }

}
