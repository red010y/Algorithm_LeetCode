package Array.MinK40;

import java.util.PriorityQueue;


public class UseHeap {
    /**
     * 思路：
     * 小顶堆实现
     * heap，把数组元素放入堆，获取堆顶元素k次
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] result=new int[k];
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        //插入操作logn,整体nlogn
        for (int i:arr)heap.add(i);
        for (int i=0;i<k;i++)result[i]=heap.remove();
        return result;
    }

    /**
     * 思路：
     * 大顶堆实现
     * 把前k个元素放入堆，后续的元素如果比堆顶元素小，移除堆顶元素，加入新元素
     */
    public int[] getLeastNumbers2(int[] arr, int k) {
        int[] result=new int[k];
        if (k==0)return result;
        PriorityQueue<Integer> heap = new PriorityQueue<>((v1,v2)->v2-v1);
        for (int i=0;i<arr.length;i++){
            if (i<k)heap.add(arr[i]);
            else {
                if (heap.peek()>arr[i]){
                    heap.remove();
                    heap.add(arr[i]);
                }
            }
        }
        int i=0;
        for (int num : heap)result[i++]=num;
//        for (int i=0;i<k;i++)result[i]=heap.remove();
        return result;
    }
}
