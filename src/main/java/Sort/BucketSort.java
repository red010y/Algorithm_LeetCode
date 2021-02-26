package Sort;

import java.util.*;

/**
 * 思路：
 * 桶排序
 */
public class BucketSort {

    public int[] topKFrequent(int[] nums, int k) {
        int result[]=new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        List[] bucket=new List[nums.length+1];
        for (int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for (int num:map.keySet()){
            Integer frequent = map.get(num);
            if (bucket[frequent]==null){
                bucket[frequent]=new ArrayList();
            }
            bucket[frequent].add(num);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i=bucket.length-1;i>=0&&list.size()<k;i--){
            if (bucket[i]!=null) {
                list.addAll(bucket[i]);
            }
        }

        for (int i=0;i<k;i++){
            result[i]=list.get(i);
        }
        return result;
    }

//    public int[] topKFrequent(int[] nums, int k) {
//        int result[]=new int[k];
//        HashMap<Integer, Integer> map = new HashMap<>();
//        PriorityQueue<Integer> heap = new PriorityQueue<>((v1,v2)->map.get(v1)-map.get(v2));
//        for (int i: nums){
//            map.put(i,map.getOrDefault(i,0)+1);
//        }
//        for (int i:map.keySet()){
//            heap.offer(i);
//            if (heap.size()>k){
//                heap.poll();
//            }
//        }
//        for (int i=0;i<k;i++){
//            result[i]=heap.poll();
//        }
//        return result;
//    }
}
