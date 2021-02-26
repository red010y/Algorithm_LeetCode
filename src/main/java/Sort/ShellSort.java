package Sort;

//为什么不进行一次的插入排序？反而进行很多次的换位后最后在进行一次插入排序？
//
//由于前两趟的插入排序中记录的关键字是和同一子序列中的前一个记录的关键字进行比较，
//因此关键字较小的记录就不是一步一步地向前挪动，而是跳跃式地往前移，从而使得进行最后一趟排序时，
//整个序列已经做到基本有序，只要作记录的少量比较和移动即可。因此希尔排序的效率要比直接插入排序高。
//
//增量序列？
//希尔中按照步数组成的序列，135，246
//
//
// *思路：
// *  步数在变化
//    增量序列
// *  只要步数+index没超过索引就可以循环x，这里把左侧当成有序，不过是一个成倍数的插入
//    setp要成倍数增加,构成增量序列进行插入排序
//
//    算法思路：
//1、选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
//2、按增量序列个数k，对序列进行k 趟排序；
//3、每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度
//
//常用的h序列由Knuth提出，该序列从1开始，通过如下公式产生：
//h = 3 * h +1
//反过来程序需要反向计算h序列，应该使用
//h = ( h - 1 ) / 3

public class ShellSort {
    public static void main(String[] args) {
        int arr[]={5,478,45645,4,46,496,46941,6,156,156,1};
        printArray(arr);
        sort(arr);
        System.out.println();
        printArray(arr);
    }
    public static void sort(int arr[]) {
        int step=0;
        int length=arr.length;
        while(step<length){
            step=step*3+1;
        }
        while (step>=1){//有几个自增序列就遍历几次
            for (int i=step;i<arr.length;i++){//i=step相当于是从插入的1开始
                int pro=i-step;//前一个元素
                int current=arr[i];//当前值
                while(pro>=0&&arr[pro]>current){//向前的元素和当前值比较，前一个元素大于当前值就换位，前一个元素必须大于0
                    arr[pro+step]=arr[pro];
                    pro-=step;
                }
                arr[pro+step]=current;//当前值放到空出来的位置上
            }
            step=(step-1)/3;
        }
    }
    public static void printArray(int arr[]){
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
