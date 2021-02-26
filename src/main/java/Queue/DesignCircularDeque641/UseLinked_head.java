package Queue.DesignCircularDeque641;
/**
 * 思路：
 * 链表实现
 * 设置2个虚拟节点head,tail
 * 头插入在head后加节点。尾插入在tail前加节点
 * 设置size记录当前链表长度，设置capacity记录我们设置的链表长度
 * 队空：size==0
 * 队满：size==capacity
 */
public class UseLinked_head {

    class MyCircularDeque {
        public class Node{
            int value;
            Node pre,next;
            public Node(int value){
                this.value=value;
            }
        }
        Node head,tail;
        int size,capacity;
        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDeque(int k) {
            head=new Node(-1);
            tail=new Node(-1);
            head.next=tail;
            tail.pre=head;
            capacity=k;
            size=0;
        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
            if (size==capacity)return false;
            Node node = new Node(value);
            node.pre=head;
            node.next=head.next;
            head.next.pre=node;
            head.next=node;
            size++;
            return true;

        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
            if (size==capacity)return false;
            Node node = new Node(value);
            node.next=tail;
            node.pre=tail.pre;
            tail.pre.next=node;
            tail.pre=node;
            size++;
            return true;
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
            if (size==0)return false;
            head.next.next.pre=head;
            head.next=head.next.next;
            size--;
            return true;
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {
            if (size==0)return false;
            tail.pre.pre.next=tail;
            tail.pre=tail.pre.pre;
            size--;
            return true;
        }

        /** Get the front item from the deque. */
        public int getFront() {
            return head.next.value;
        }

        /** Get the last item from the deque. */
        public int getRear() {
            return tail.pre.value;
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return size==0;
        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            return size==capacity;
        }
    }
}


