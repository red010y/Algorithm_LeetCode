package Sort;

/*
*思路：
*第二个元素开始和前面的元素进行比较--排序
*如果当前值比排好序的数组大，进行插入，其后的元素向后移
* */
public class InsertionSort {
    public static void main(String[] args) {
        int arr[]={5,478,45645,4,46,496,46941,6,156,156,1};
        printArray(arr);
        sort(arr);
        System.out.println();
        printArray(arr);
    }
    public static void sort(int arr[]) {
        int current;
        int nullIndex;//少进行判断，定义一个变量去减少判断，空出来的位置的索引
        for (int i = 1; i < arr.length; i++) {
            nullIndex = i;
            current = arr[i];
            for (int j = i - 1; j >= 0; j--) {//左侧是排好序的
                if (current < arr[j]) {//当前的牌比左边的小，发生位移,要比他大那就不用动，这样从一开始就动不用担心出现值丢失
                    arr[j + 1] = arr[j];
                    nullIndex = j;
//                    if (j==0){//如果是0的逻辑
//                        arr[j]=current;
//                    }
//                }else{
//                    arr[j+1]=current;
//                    break;
//                }
                }
                //少进行判断，定义一个变量去减少判断
                arr[nullIndex] = current;//当前值放到空出来的位置上
            }
        }
    }
    public static void printArray(int arr[]){
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}

/*
别人家的代码！！！(比我的少了一次判断)
* public class ChaRuPaiXu {
    public static void main(String[] args) {
        int array[] = {1,2,4,3,9,7,8,6};
        int index = 0;
        int current = 0;

        for (int i = 1; i < array.length; i++) {
            index = i - 1;        //左边的排是排好序的
            current = array[i];   //表示当前取到的扑克牌
            while (index >= 0 && array[index] > current) {   //如果左边的排比取到的排大则右移
                array[index + 1] = array[index];
                index--;
            }
            array[index + 1] = current;  //直到该手牌比抓到的牌小(或二者相等)，将抓到的牌插入到该手牌右边
        }

        for( int i = 0 ; i < array.length ; i++ ){
            System.out.print(array[i]+" ");
        }
    }
 }

* */
