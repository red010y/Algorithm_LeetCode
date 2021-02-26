package Array.AddOne66;

/**
 * 思路：
 * 从前往后遍历数组，当前值+1，之后模以10，如果当前值小于9直接返回
 * 如果遍历完都没返回结果，那么结果一定是10000....，
 * 所以就新建一个数组是原数组长度+1，新数组的0位置放置1即可
 */
public class Brute2 {

    public int[] plusOne(int[] digits) {
        for (int i=digits.length-1;i>=0;i--){
            digits[i]+=1;
            digits[i]%=10;
            if (digits[i]!=0)return digits;
        }
        int[] result = new int[digits.length + 1];
        result[0]=1;
        return result;
    }
}
