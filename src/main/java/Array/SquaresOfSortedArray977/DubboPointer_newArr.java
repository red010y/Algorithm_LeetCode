package Array.SquaresOfSortedArray977;

/**
 * 思路
 * 指向头尾，从后往前遍历，每次找到最大的那个值放到尾部
 */
public class DubboPointer_newArr {
    public static void main(String[] args) {
        int arr[]={-4,-1,0,3,10};
        int[] result = dubboPointer(arr);
    }

    private static int[] dubboPointer(int[] arr) {
        int head=0,tail=arr.length-1;
        int result[]=new int[arr.length];
        for (int i=arr.length-1;i>=0;i--){
            if (Math.abs(arr[head])>Math.abs(arr[tail])){
                result[i]=arr[head]*arr[head];
                head++;
            }else {
                result[i]=arr[tail]*arr[tail];
                tail--;
            }
        }
        return result;
    }

//    private static int[] dubboPointer(int[] arr) {
//        int head=0,tail=arr.length-1;
//        int result[]=new int[arr.length];
//        for (int i=arr.length-1;i>=0;i--){
//            int left=arr[head]*arr[head];
//            int right=arr[tail]*arr[tail];
//            if (left>right){
//                result[i]=left;
//                head++;
//            }else {
//                result[i]=right;
//                tail--;
//            }
//        }
//        return result;
//    }
}
