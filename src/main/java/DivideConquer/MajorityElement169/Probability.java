package DivideConquer.MajorityElement169;

import java.util.Random;

/**
 * 思路：
 * 随机挑一个数，大概率是众数
 */
public class Probability {
    public int majorityElement(int[] nums) {
        while (true) {
            int random_num = randomGetNum(nums);
            boolean result = isMajority(random_num, nums);
            if (result) return random_num;
        }
    }

    private boolean isMajority(int random_num, int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num == random_num) count++;
        }
        return count > nums.length / 2;
    }

    private int randomGetNum(int[] nums) {
        Random random = new Random();
        int index = random.nextInt(nums.length);
        return nums[index];
    }
}
