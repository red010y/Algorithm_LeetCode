package DivideConquer.MajorityElement169;

/**
 * 思路：
 * 分治：查整个数组的众数，可以分解为子问题：比较左右两边的众数
 * 切分数组，比较左右两边的众数
 * 如果众数一样就返回
 * 不一样就比较左右众数的个数，多的那个就是众数
 */
public class DivideConquer {
    public int majorityElement(int[] nums) {
        return recursive(0,nums.length-1,nums);
    }

    private int recursive(int left, int right, int[] nums) {
        if (left==right)return nums[left];
        int mid=(left+right)/2;
        int l_majority = recursive(left, mid, nums);
        int r_majority = recursive(mid + 1, right, nums);
        int l_m_count=getCount(l_majority,left,right,nums);
        int r_m_count=getCount(r_majority, left, right, nums);
        return l_m_count>r_m_count?l_majority:r_majority;
    }

    private int getCount(int majority, int left, int right, int[] nums) {
        int count=0;
        for (int i=left;i<=right;i++){
            if (nums[i]==majority)count++;
        }
        return count;
    }
}
