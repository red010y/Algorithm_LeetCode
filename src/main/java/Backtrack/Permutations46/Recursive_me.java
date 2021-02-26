package Backtrack.Permutations46;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
/**
 * 我写的和回溯的哪个思路一样，不过他的更巧妙的设计了当前格子存放的不是之前放过的数
 * 思路：
 * 往格子里放数，当前格子的数需要遍历数组，并且不能是之前放过的
 * 因为没有从重复数字用set来存放之前放过的数。
 * 每次递归结束就从set和list中移除这个数
 */
public class Recursive_me {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        recursive(nums,0,result,list,set);
        return result;
    }

    private void recursive(int[] nums, int lattice, ArrayList<List<Integer>> result, LinkedList<Integer> list, HashSet<Integer> set) {
        if (lattice==nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i:nums){
            if (set.add(i)){
                list.add(i);
                recursive(nums,lattice+1,result,list,set);
                list.removeLast();
                set.remove(i);
            }
        }
    }
}
