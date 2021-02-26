package DivideConquer.MajorityElement169;

public class Bit {
    public static void main(String[] args) {
        int[] arr={-1,-3,-3};
        new Bit().majorityElement(arr);
    }

    /**
     * 思路：
     * 核心思路：众数超过数组的一半，也就意味着其二进制位上的每一个数都超过数组的一半
     */
    public int majorityElement(int[] nums) {
        int result = 0, k = nums.length >> 1;
        //符号位所以只能到31
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                //num右移i后其二进制是否为1。也就是第i为二进制是否为1
                count += num >> i & 1;
                if (count > k) {
                    //众数通过不断的累加其二进制位的十进制值，最后就组成一个完整的十进制众数
                    result += 1 << i;
                    break;
                }
            }
        }
        return result;
    }

    public int majorityElement2(int[] nums) {
        int[] bits = new int[32];
        for (int num : nums){
            for (int i=0;i<bits.length;i++){
                if (((num>>i)&1)==1)bits[i]++;
            }
        }
        int result=0;
        for (int i=0;i<bits.length;i++){
            if (bits[i]>nums.length/2)result+=(1<<i);
        }
        return result;
    }

}
