package Array.AddOne66;

/**
 * 思路：
 * 从前往后遍历数组，如果不是9就在当前位置+1返回
 * 如果是9，就把当前位置变为0，之后继续向前遍历
 * 如果遍历到数组的0位置仍然是9，那么就新建一个数组是原数组长度+1，把原数组拷贝到新数组。
 */
public class Brute1 {


    public int[] plusOne(int[] digits) {
        for (int i=digits.length-1;i>=0;i--){
            if (digits[i]!=9){
                digits[i]+=1;
                break;
            }else {
                digits[i]=0;
                if (i==0) {
                    int[] result = new int[digits.length + 1];
                    result[0]=1;
                    //如果能到最高位这个数一定是10000....，所以不用进行移动的操作
//                    System.arraycopy(digits,0,result,1,digits.length);
                    return result;
                }
            }
        }
        return digits;
    }
}
