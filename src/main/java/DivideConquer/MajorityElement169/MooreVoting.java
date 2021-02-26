package DivideConquer.MajorityElement169;

/**
 * 思路：
 * 这个思路很巧妙，众数一定比其他数的总和多
 * 把第一个数记作众数，如果是第一个数count++，不是count--
 * 如果count==0说明这个数不是众数，把其他的数作为众数
 * 继续循环直到所有的数走完
 */
public class MooreVoting {
    public int majorityElement(int[] nums) {
        int count=0,majority=0;
        for (int num:nums){
            if (count==0)majority=num;
            if (num==majority)count++;
            else count--;
        }
        return majority;
    }
}
