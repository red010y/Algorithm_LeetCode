package Queue.SlidingWindowMaximum239;

/**
 * 思路：
 * 比较k范围内的值，找到并记录
 * 如果当前的max等于start-1，前移的时候就重新从start到end找max。
 * 如果不等于，直接比较max和end
 */
public class Brute {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int start=0,end=k-1,max=nums[0];
        int[] result=new int[nums.length-k+1];
        while (end<nums.length){
            if (start==0||max == nums[start-1]){
                max=nums[start];
                for (int i=start;i<=end;i++){
                    max=Math.max(max,nums[i]);
                }
            }else {
                max=Math.max(max,nums[end]);
            }
            result[start++]=max;
            end++;
        }
        return result;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        int start=0,end=k,max=nums[0];
        int[] result=new int[nums.length-k+1];
        for (int i=0;i<nums.length;i++){
            if (nums[i]>max)max=nums[i];
            else {
                if (end!=k){
                    if (max==nums[start-1]) {
                        max = nums[start];
                        for (int j = start; j < end; j++) {
                            if (nums[j] > max) max = nums[j];
                        }
                    }
                }
            }
            if (i>=k-1) {
                result[start] = max;
                start++;end++;
            }
        }
        return result;
    }

}
