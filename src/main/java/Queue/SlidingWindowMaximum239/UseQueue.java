package Queue.SlidingWindowMaximum239;

import java.util.ArrayDeque;

/**
 * 思路：
 * 超过k就从队列中出队
 */
public class UseQueue {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] result=new int[nums.length-k+1];
        int max=nums[0];
        int index=0;
        for (int i=0;i<nums.length;i++){
            queue.offer(nums[i]);
            if (i>=k){
                Integer poll = queue.poll();
                if (poll==max){
                    max=nums[i-k+1];
                    for (int j=i-k+1;j<=i;j++){
                        if (nums[j]>max)max=nums[j];
                    }
                }
            }
            if (nums[i]>max)max=nums[i];
            if (i>=k-1)result[index++]=max;
        }
        return result;
    }
}
