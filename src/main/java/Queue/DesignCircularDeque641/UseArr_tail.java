package Queue.DesignCircularDeque641;

/**
 * 这个题的解法都不是正常的deque，在头部放元素，而是头结点加入就在数组中一直后移，尾节点加入就一直前移。
 * 但是最终他记录的start和end，所以能实现获取头和尾，设计算是一种另辟蹊径吧。
 *
 * 思路：
 * 使用数组实现双端队列
 * 如果头尾在一样，就是null
 * 如果(尾节点+1)%cap=头结点就是队满
 * 每次插入和删除都要对头尾节点进行模操作
 * 头插入从数组的尾部开始插入，一直前移
 * 尾插入从数组的头部开始插入，一直后移
 *
 */
public class UseArr_tail {
    public static void main(String[] args) {
        int k = 3;
        UseArr_tail list = new UseArr_tail(k);
        list.insertFront(10);
        list.insertFront(1);
        list.deleteFront();
        list.insertLast(99);
        list.insertFront(2);
        list.insertFront(4);
        list.insertFront(5);
    }

    int[] arr;
    int front, rear, cap;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public UseArr_tail(int k) {
        arr = new int[k + 1];
        front = 0;
        rear = 0;
        cap = k + 1;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull()) return false;
        arr[front] = value;
        front = (front + 1) % cap;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull()) return false;
        rear = (rear - 1 + cap) % cap;
        arr[rear] = value;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty()) return false;
        front = (front - 1 + cap) % cap;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty()) return false;
        rear = (rear + 1) % cap;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        return isEmpty() ? -1 : arr[(front - 1 + cap) % cap];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return isEmpty() ? -1 : arr[rear];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return front == rear;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return (front + 1) % cap == rear;
    }
}


