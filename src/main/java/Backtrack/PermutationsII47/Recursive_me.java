package Backtrack.PermutationsII47;

import java.util.*;
/**
 * 思路：
 * 每个格子都可以存放所有数字
 * 当前的数和之后的数不同才进行换位
 */
public class Recursive_me {
    public static void main(String[] args) {
        int[] arr={1,1,2};
        new Recursive_me().permuteUnique(arr);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        for (int num:nums)list.add(num);
        recursive(result,list,0);
        return result;
    }

    private void recursive(ArrayList<List<Integer>> result, LinkedList<Integer> list, int lattice) {
        if (lattice==list.size()){
            result.add(new ArrayList<>(list));
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i=lattice;i<list.size();i++){
            //set看的是上一个格子换位后的剩余数。211，到了第二个格子看的是11（这就是为什么这不能add.nums[x]的原因）
            if (set.add(list.get(i))){
                Collections.swap(list,lattice,i);
                recursive(result,list,lattice+1);
                Collections.swap(list,lattice,i);
            }
        }
    }


    //出错的
    public List<List<Integer>> permuteUnique2(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        for (int num:nums)list.add(num);
        recursive2(result,list,nums,0);
        return result;
    }

    private void recursive2(ArrayList<List<Integer>> result, LinkedList<Integer> list, int[] nums, int lattice) {
        if (lattice==nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i=lattice;i<nums.length;i++){
            //错就错在i和i-1比较了，进行交换后不是有序的了，已经不适用了
            //否则会出现：第二个格子是1时：212。前后21不同1和1换。之后212,前后12不同，1和2换：221 此时在第三个格子，21不同又交换一次: 212重复。
            if (i==0||list.get(i)!=list.get(i-1)){
                Collections.swap(list,lattice,i);
                recursive2(result,list,nums,lattice+1);
                Collections.swap(list,lattice,i);
            }
        }
    }

    //出错的
    public List<List<Integer>> permuteUnique3(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i:nums)list.add(i);
        recursive3(result,list,nums,0);
        return result;
    }

    private void recursive3(ArrayList<List<Integer>> result, ArrayList<Integer> list, int[] nums, int lattice) {
        if (lattice==nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i=lattice;i<nums.length;i++){
            //nums就没变换，list换成211，本来只进行一次换位。但是nums还看的是112。会进行两次换位
            if (set.add(nums[i])){
                Collections.swap(list,lattice,i);
                recursive3(result,list,nums,lattice+1);
                Collections.swap(list,lattice,i);
            }
        }
    }
}
