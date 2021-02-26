package Backtrack.Permutations46;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 思路：
 * 放格子，第一个格子放所有的数
 * 第二个放除第一个格子外所有的数
 * 第三个格子放除1,2格子中的所有的数
 * 。。。
 * 最后就是所有的可能性
 *
 * 为了实现上面的效果
 * 我们把nums所有的数存入list，之后在其每个位置（格子）上进行交换
 * 先和自身换，之后和后面所有的数进行交换。这样第一个格子就存储了所有的数
 * 对于后面的格子用递归，进行同样的操作
 * 最后要把变换后的数换回来，以便下次递归不重复
 */
public class Recursive {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int num:nums)list.add(num);
        backtrack(nums.length,0,list,result);
        return result;
    }

    private void backtrack(int length, int lattice, ArrayList<Integer> list, ArrayList<List<Integer>> result) {
        if (lattice==length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i=lattice;i<length;i++){
            Collections.swap(list,lattice,i);
            backtrack(length,lattice+1,list,result);
            Collections.swap(list,lattice,i);
        }
    }
}
