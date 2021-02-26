package Queue.SlidingWindowMaximum239;

import java.util.ArrayDeque;

/**
 * 思路：
 * 双端队列实现
 * 每进来一个数前，先要和前面的数进行比较，如果当前的数比前面的数大，就进行出队操作
 * 判断当前的队列头部的元素下标有没有超出窗口范围
 * 在队列的尾部加入元素
 * 如果达到了窗口的长度，就进行一次最大值的记录
 */
public class UseDequeue {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] result = new int[nums.length-k+1];
        int index=0;
        for (int i = 0; i < nums.length; i++) {

            while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                queue.pollLast();
            }

            while (!queue.isEmpty() &&queue.peek()<i-k+1){
                queue.pollFirst();
            }

            queue.offerLast(i);

            if (i>=k-1){
                result[index++]=nums[queue.peek()];
            }
        }
        return result;
    }
}
