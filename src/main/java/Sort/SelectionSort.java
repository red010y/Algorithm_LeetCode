package Sort;
/*
* 思路：
* 遍历数组，每次记录最小元素
* 最小的元素，放在数组最前面
* */
public class SelectionSort {
    public static void main(String[] args) {
        int arr[]={5,478,45645,4,46,496,46941,6,156,156,1};
        printArray(arr);
        sort(arr);
        System.out.println();
        printArray(arr);
    }
    public static void sort(int arr[]){
        int minIndex;
        int tmp;
        for (int i=0;i<arr.length-1;i++){
            minIndex=i;
            for (int j=i+1;j<arr.length;j++){
                if (arr[minIndex]>arr[j]){
                    minIndex=j;
                }
            }
            tmp=arr[i];
            arr[i]=arr[minIndex];
            arr[minIndex]=tmp;
        }
    }
    public static void printArray(int arr[]){
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
