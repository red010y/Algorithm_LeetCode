package Queue.CreateQueue;

/**
 * 思路：
 * 用数组实现队列
 * 入队：判断队列是否满了。没满，加入元素，下标后移
 * 出队：判断队列是否为null。出队的是下标0的元素。不为null，数组整体前移1。更新tail
 */
public class Arr_PollMove {

    public static void main(String[] args) {
        Arr_PollMove queue = new Arr_PollMove(2);
        queue.offer("1");
        queue.offer("2");

        boolean offer3 = queue.offer("3");
        System.out.println(offer3);//false

        String poll1 = queue.poll();
        System.out.println(poll1);//1

        String poll2 = queue.poll();
        System.out.println(poll2);//2

        String poll3 = queue.poll();
        System.out.println(poll3);//null
    }

    String[] arr;
    int tail;

    public Arr_PollMove(int capacity){
        arr=new String[capacity];
        tail=0;
    }
    public boolean offer(String value){
        //队满
        if (tail==arr.length)return false;
        arr[tail++]=value;
        return true;
    }

    public String poll(){
        //队空
        if (tail==0)return null;
        String pollS = arr[0];
        System.arraycopy(arr,1,arr,0,arr.length-1);
        //更新tail
        tail--;
        return pollS;
    }

}
