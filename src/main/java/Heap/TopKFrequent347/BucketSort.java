package Heap.TopKFrequent347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 思路：
 * 用map存储数的频次，k数，v频次
 * 创建桶ArrayList，下标是频次，元素是集合
 * 逆序遍历桶
 */
public class BucketSort {
    public static void main(String[] args) {
        int[] arr= {1,1,2,2,3,3};
        topKFrequent(arr,2);
    }
    public static int[] topKFrequent(int[] nums, int k) {
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
}
