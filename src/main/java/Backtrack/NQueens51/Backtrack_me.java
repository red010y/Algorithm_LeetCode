package Backtrack.NQueens51;

import java.util.*;
/**
 * 思路：
 * 核心思路：放格子，判断格子的位置是否可放：遍历之前所有格子，不能是 之前格子的位置+-（当前层-之前的层）
 * 用map存储。k格子位置，当前所在的层
 * 递归的进行直到到达n层为止
 * 如果当前位置可以放，就放入queue中
 * 递归结束从queue和map中移除当前位置
 */
public class Backtrack_me {
    public List<List<String>> solveNQueens(int n) {
        int lattice=0;
        LinkedList<Integer> queue = new LinkedList<>();
        ArrayList<List<String>> result = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap();
        recursive(map,result,queue,lattice,n);
        return result;
    }

    private void recursive(HashMap<Integer,Integer> map, ArrayList<List<String>> result, LinkedList<Integer> queue, int level, int n) {
        if (level==n){
            ArrayList<Integer> result_nums = new ArrayList<>(queue);
            ArrayList<String> list = new ArrayList<>();
            for (int i=0;i<result_nums.size();i++){
                Integer num = result_nums.get(i);
                StringBuilder sb = new StringBuilder();
                for (int j=0;j<n;j++) {
                    if (j==num){
                        sb.append("Q");
                    }else {
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }
            result.add(list);
            return;
        }
        for (int i=0;i<n;i++){
            HashSet<Integer> set = new HashSet<>();
            for (int key:map.keySet()){
                set.add(key);
                if (key+(level-map.get(key))<=n)
                    set.add(key+(level-map.get(key)));
                if (key-(level-map.get(key))>=0)
                    set.add(key-(level-map.get(key)));
            }
            if (level==0||!set.contains(i)){
                queue.offer(i);
                map.put(i,level);
                recursive(map, result, queue, level+1, n);
                queue.removeLast();
                map.remove(i);
            }
        }
    }


    /**
     * 思路：
     * 核心思路：确定当前Queen的位置，遍历之前所有Queen，不能是 之前Queen的位置+-（当前层-之前的层）
     * 用数组来存储数据，索引就是当前层，值就是Queen的位置
     * 递归的放Queen的位置，达到了数组的长度，就构建结果集
     */
    public List<List<String>> solveNQueens2(int n) {
        ArrayList<List<String>> result = new ArrayList<>();
        int[] arr = new int[n];
        recursive2(result,arr,0);
        return result;
    }

    private void recursive2(ArrayList<List<String>> result, int[] arr, int level) {
        if (level==arr.length){
            greateResult(arr,result);
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int j = 0; j < level; j++) {
            set.add(arr[j] - (level-j));
            set.add(arr[j] + (level-j));
            set.add(arr[j]);
        }
        for (int i=0;i<arr.length;i++){
            if (level==0||!set.contains(i)){
                arr[level]=i;
                recursive2(result, arr, level+1);
            }
        }
    }

    private void greateResult(int[] arr, ArrayList<List<String>> result) {
        ArrayList<String> list = new ArrayList<>();
        for (int i=0;i<arr.length;i++){
            StringBuilder sb = new StringBuilder();
            for (int j=0;j<arr.length;j++){
                if (arr[i]==j){
                    sb.append("Q");
                }else {
                    sb.append(".");
                }
            }
            list.add(sb.toString());
        }
        result.add(list);
    }
}

