package Backtrack.Combinations77;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 思路：
 *  如果当前队列的长度是k，就往结果集中加入
 *  遍历所有可能的组合，1所有，2所有。。。
 *  把当前的数加入队列
 *  删除队列尾部，加入新的可能
 */
public class Recursive {

    public List<List<Integer>> combine(int n, int k) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        bracktrack(result,queue,n,k,1);
        return result;
    }

    private void bracktrack(ArrayList<List<Integer>> result, LinkedList<Integer> queue, int n, int k,int curr) {
        if (queue.size()==k) {
            result.add(new LinkedList<>(queue));
            return;
        }
        for (int i=curr;i<=n;i++){
            queue.offer(i);
            bracktrack(result,queue,n,k,i+1);
            queue.removeLast();
        }
    }

    /**
     * 思路：
     * 从1开始不断的，递归的往list中放入元素
     * 如果长度达到了k就返回
     */
    public List<List<Integer>> combine2(int n, int k) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        recursive2(result,1,n,k,list);
        return result;
    }

    private void recursive2(ArrayList<List<Integer>> result, int curr, int n,int k, ArrayList<Integer> list) {
        if (list.size()==k){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i=curr;i<=n;i++){
            list.add(i);
            recursive2(result,i+1,n,k,list);
            list.remove(list.size()-1);
        }
    }

    /**
     * 思路：
     * 从1开始不断的填充格子，递归的往list中放入元素
     * 如果格子长度达到了k就返回
     * 之后删除当前格子的数
     */
    public List<List<Integer>> combine3(int n, int k) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        recursive3(result,list,1,0,n,k);
        return result;
    }

    private void recursive3(ArrayList<List<Integer>> result, ArrayList<Integer> list, int curr, int lattice, int n, int k) {
        if (lattice==k){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i=curr;i<=n;i++){
            list.add(i);
            recursive3(result,list, i+1, lattice+1,n,k);
            list.remove(lattice);
        }
    }

}
