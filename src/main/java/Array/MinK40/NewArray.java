package Array.MinK40;

/**
 * 思路：
 * 在有限数据的情况下
 * 创建一个大的数组，存放arr数组中的所有数据，把这些数据的值作为索引，出现的次数作为值
 */
public class NewArray {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] result=new int[k];
        int index=0;
        int[] count = new int[10000];
        for (int i:arr){
            count[i]++;
        }
        for (int i=0;i<count.length;i++){
            while (count[i]>0){
                if (index==k)return result;
                result[index++]=i;
                count[i]--;
            }
        }
        return result;
    }
}
