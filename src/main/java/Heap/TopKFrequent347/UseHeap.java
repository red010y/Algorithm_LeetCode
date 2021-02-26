package Heap.TopKFrequent347;

import java.util.*;

/**
 * 思路：
 * 统计词频在新的map上，k是数，v是词频
 * heap中存放词频，统计前k个
 */
public class UseHeap {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((v1,v2)->map.get(v2)-map.get(v1));
        for (int i:map.keySet()){
            heap.add(i);
        }
        for (int i=0;i<k;i++){
            result[i]=heap.remove();
        }
        return result;
    }
}
