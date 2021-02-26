package Queue.CreateQueue;

/**
 * 思路：
 * 核心思路：给数组预留一个位置不存放数据。防止队空和队满的判定条件一样
 *
 * 数组实现循环队列
 * 入队：
 * 队满条件：(head + 1) % arr.length==tail
 * 没有满的时候入队，并且tail后移:tail=(tail+1)%arr.length
 * 出队：
 * 队空条件：head==tail
 * head出队，后移head：head=(head+1)%arr.length;
 */
public class CycleQueue {
    public static void main(String[] args) {
        CycleQueue circularQueue = new CycleQueue(3);
        circularQueue.offer("1");
        circularQueue.offer("2");

        boolean offer3 = circularQueue.offer("3");
        System.out.println(offer3);//false

        String poll1 = circularQueue.poll();
        System.out.println(poll1);//1

        String poll2 = circularQueue.poll();
        System.out.println(poll2);//2

        String poll3 = circularQueue.poll();
        System.out.println(poll3);//null

    }

    String[] arr;
    int head=0,tail=0;

    public CycleQueue(int length){
        arr=new String[length];
    }

    public boolean offer(String s){
        if ((tail + 1) % arr.length==head)return false;
        arr[tail]=s;
        tail=(tail+1)%arr.length;
        return true;
    }

    public String poll(){
        if (head==tail)return null;
        String s = arr[head];
        head=(head+1)%arr.length;
        return s;
    }

}
