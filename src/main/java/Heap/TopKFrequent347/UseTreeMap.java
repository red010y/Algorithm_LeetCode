package Heap.TopKFrequent347;


import java.util.*;

/**
 * 思路：
 * 二叉搜索树
 * 统计词频在新的map上，k是数，v是词频
 * TreeMap中存放，k是词频，v是数的集合
 * 之后获取前k高词频的数
 */
public class UseTreeMap {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        TreeMap<Integer, List<Integer>> bST = new TreeMap<>();
        for (int num:map.keySet()){
            Integer frequent = map.get(num);
            if (!bST.containsKey(frequent)){
                bST.put(frequent,new ArrayList());
            }
            bST.get(frequent).add(num);
        }
        List<Integer> list = new ArrayList<>();
        while (list.size()<k){
            list.addAll(bST.pollLastEntry().getValue());
        }
        for (int i=0;i<k;i++){
            result[i]= list.get(i);
        }
        return result;
    }
}
