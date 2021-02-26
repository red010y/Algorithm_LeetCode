package Queue.DesignCircularDeque641;

/**
 * 思路：
 * 为了头插入和尾插入在一个位置，对他们中的一个要做处理，这里处理头加入。头加入，加入到数组的末尾的位置
 * 循环队列队空的条件：head==tail
 * 循环队列队满的条件：head==(tail+1)%capacity
 * 经过我们处理后，头可以直接获取
 * 尾获取需要-1
 * 删除头需要+1
 * 删除尾需要-1
 * 当然上述的这些操作为了防止越界需要做越界处理
 */
public class UseArr_head {
    class MyCircularDeque {
        int arr[];
        int head,tail,capacity;
        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDeque(int k) {
            capacity=k+1;
            arr=new int[capacity];
            head=0;
            tail=0;
        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
            if(isFull())return false;
            //?每次在head加入一个元素的操作，head需要往他前面的位置加入一个元素（好比tail后移）
            head=(head-1+capacity)%capacity;
            //这行不能和上面的head赋值互换位置
            // 因为这关系到我们deleteFront()操作，
            // 还有我们insertLast(int value)操作，两个位置可能会重合，
            // 还有我们getFront()操作
            arr[head]=value;
            return true;
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
            if (isFull())return false;
            arr[tail]=value;
            tail=(tail+1)%capacity;
            return true;
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
            if (isEmpty())return false;
            head=(head+1)%capacity;
            return true;
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {
            if (isEmpty())return false;
            tail=(tail-1+capacity)%capacity;
            return true;
        }

        /** Get the front item from the deque. */
        public int getFront() {
            if (isEmpty())return -1;
            return arr[head];
        }

        /** Get the last item from the deque. */
        public int getRear() {
            if (isEmpty())return -1;
            //tail指向的是没有数据的那个位置，所以tail要做处理
            return arr[(tail-1+capacity)%capacity];
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return head==tail;
        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            return (tail+1)%capacity==head;
        }
    }
}
