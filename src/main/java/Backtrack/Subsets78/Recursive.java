package Backtrack.Subsets78;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * 思路：
 * 获取每个数，每次递归都是当前数+1，找到其所有的组合，每次都加入结果集
 * 递归结束后删除这个数
 * []
 * 1的所有可能：1,12,123,12,13,1
 * 2的所有可能：2,23,2
 * 3的所有可能：3
 */
public class Recursive {

    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        result.add(new ArrayList<>());
        recursive(result,queue,nums,0);
        return result;
    }

    private void recursive(ArrayList<List<Integer>> result, LinkedList<Integer> queue, int[] nums, int lattice) {
        for (int i=lattice;i<nums.length;i++){
            queue.offer(nums[i]);
            result.add(new ArrayList<>(queue));
            recursive(result, queue, nums, i+1);
            queue.removeLast();
        }
    }

    /**
     * 思路：
     * 格子，每个格子可选可不选。
     * 123
     * 填充格子（N代表不填充，Y代表填充，X代表可能是N或Y）
     * NNN
     * NNY
     * NYX-->NYN or NYY
     */
    public List<List<Integer>> subsets2(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        recursive2(result,queue,nums,0);
        return result;
    }

    private void recursive2(ArrayList<List<Integer>> result, LinkedList<Integer> queue, int[] nums, int lattice) {
        if (lattice==nums.length){
            result.add(new ArrayList<>(queue));
            return;
        }
        //不填充
        recursive2(result, queue, nums, lattice+1);
        //填充
        queue.offer(nums[lattice]);
        recursive2(result, queue, nums, lattice+1);
//        浅拷贝，这样就不用还原状态了
//        recursive2(result, (LinkedList)queue.clone(), nums, lattice+1);
        //还原状态
        queue.removeLast();
    }

}
