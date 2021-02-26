package Array.Jump;

/**
 * 思路：
 * 获取第一个位置的值，遍历前面的最大值，count++
 * 与当前位置的距离+角标=能走到的位置
 * 和最大值比较，如果大替换，如果能走到的位置正好==数组长度，结束
 */
public class Brute {
    public static void main(String[] args) {
        int arr[]={5,3,4};
        int jump = jump(arr);
        System.out.println(jump);
    }

    public static int jump(int[] nums) {
        if (nums.length==0)return 0;
        int currentIndex=0;
        int count=0;
        while (currentIndex!=nums.length-1){
            int move = nums[currentIndex];
            count++;
            int max=0;
            int index = currentIndex;
            for (int i=currentIndex+1;i<nums.length&&i<=index+move;i++){
                int maxRange=nums[i]+i;
                if (maxRange>max) {
                    max = maxRange;
                    currentIndex=i;
                }
                if (currentIndex==nums.length-1) return count;
            }
        }
        return count;
    }

//    public static boolean canJump(int[] nums) {
//        int n = nums.length;
//        int rightmost = 0;
//        int count=0;
//        for (int i = 0; i < n; ++i) {
//            if (i <= rightmost) {
//                count++;
//                rightmost = Math.max(rightmost, i + nums[i]);
//                if (rightmost >= n - 1) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
}
