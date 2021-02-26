package Queue.CreateQueue;

/**
 * 思路：
 * 入队：
 * 判断队列是否已经满了，判断队列的head指针是否在0位置。
 * 如果满了，并且head==0说明队列真的满了。
 * 如果满了，head不在0位置，说明数据有剩余空间，进行数据迁移。迁移后更新head，tail
 * 如果队列不满，加入数据，后移tail
 * 出队：
 * 判断队列是否为null。不为null，不进行数据迁移，让head指针向后指
 */
public class Arr_OfferMove {

    public static void main(String[] args) {
        Arr_OfferMove queue = new Arr_OfferMove(2);
        queue.offer("1");
        queue.offer("2");


        String poll1 = queue.poll();
        System.out.println(poll1);//1

        boolean offer3 = queue.offer("3");
        System.out.println(offer3);//true
    }

    String[] arr;
    int head,tail;

    public Arr_OfferMove(int capacity){
        arr=new String[capacity];
        tail=0;
        head=0;
    }
    public boolean offer(String value){
        if (tail==arr.length&&head!=0) {
            System.arraycopy(arr, head, arr, 0, arr.length - head);
            // 搬移完之后重新更新 head 和 tail
            tail-=head;
            head=0;
        }
        //队满
        if (tail==arr.length)return false;
        arr[tail++]=value;
        return true;
    }

    public String poll(){
        //队空
        if (tail==head)return null;
        String pollS = arr[head++];
        return pollS;
    }
}
