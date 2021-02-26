package Backtrack.PermutationsII47;

import java.util.*;

/**
 * 思路：
 * 112
 *  先排序
 *  当前格子数等于了数组长度返回。
 *  遍历所有的数，如果当前的数被使用continue
 * 如果前一个数等于当前的数，但是前一个数竟然没被标记，说明一件事，当前位置已经放过这个数了。前一个数没被标记 continue
 * 往list中加入当前数
 * 下钻
 * 标记当前数没被访问
 * 回撤格子中的数
 */
public class Backtrack {
    public static void main(String[] args) {
        int[] arr={1,1,2};
        new Backtrack().permuteUnique(arr);
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums,result,list,used,0);
        return result;
    }

    private void backtrack(int[] nums,ArrayList<List<Integer>> result, LinkedList<Integer> list, boolean[] used,int lattice) {
        if (lattice==nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i=0;i<nums.length;i++){
            if (used[i])continue;
            //112第一个格子走到11的时候!used[i-1]第一个1没访问过，不能向下走
            //这设计的反人类!used[i-1]，正常人怎么想出来啊。。。。
            //设计的nb，不反人类，我傻没想到。我的思维还是没跟上这个代码贡献者
            //如果前一个数等于当前的数，但是前一个数竟然没被标记，说明一件事，当前位置已经放过这个数了。
            if (i>0 && nums[i]==nums[i-1] && !used[i-1])continue;
            used[i]=true;
            list.addLast(nums[i]);
            backtrack(nums,result,list,used,lattice+1);
            used[i]=false;
            list.removeLast();
        }
    }


}
