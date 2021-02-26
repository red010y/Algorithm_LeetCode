package Queue.SlidingWindowMaximum239;

import java.util.PriorityQueue;

/**
 * 思路：
 * 大顶堆
 * 移除超出窗口范围的值
 * 如果到达窗口边界就记录一次最大值
 */
public class UseHeap {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((v1, v2) -> v2 - v1);
        int[] result = new int[nums.length - k + 1];
        int index=0;
        for (int i=0;i<nums.length;i++){
            //heap移除的是值
            if (i>=k)heap.remove(nums[i-k]);
            heap.offer(nums[i]);
            if (i>=k-1){
                result[index++]=heap.peek();
            }
        }
        return result;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((v1,v2)->v2-v1);
        int max=nums[0];
        int[] result=new int[nums.length-k+1];
        int index=0;
        for (int i=0;i<nums.length;i++){
            heap.add(nums[i]);
            if (i<k){
                if (i==k-1)result[index++]=heap.peek();
            }else {
                heap.remove(nums[index-1]);
                result[index++]=heap.peek();
            }
        }
        return result;
    }

}
