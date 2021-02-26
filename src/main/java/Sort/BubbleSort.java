package Sort;

/*
* 思路：
* 邻位比较，大的在前
* 多会结束？每次循环一次后最大的在最后，可以在下次的时候少遍历一次
* 这里能不能加一个判断，优化一下，说不定到最后几个数的时候顺序已经排好了，就不必在冒泡了
* */
public class BubbleSort {
    public static void main(String[] args) {
        int arr[]={5,7,9,1,34,7,6,13,6};
        printArray(arr);
        sort(arr);
        System.out.println();
        printArray(arr);
    }

    public static void sort(int arr[]){
        int tmp=0;
        for(int i=0;i<arr.length-1;i++){//-1是因为最后一个数肯定确定了，把大的数都排好了，最后就是最小的数
            for(int j=0;j<arr.length-i-1;j++){//-1是为了临位置比较。-i是为了不在比较选好的最大值，每次确定一个最大值
                if(arr[j]>arr[j+1]){
                    tmp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=tmp;
                }
            }
        }
    }

    public static void printArray(int arr[]){
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
