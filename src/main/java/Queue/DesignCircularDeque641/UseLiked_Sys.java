package Queue.DesignCircularDeque641;

import java.util.LinkedList;

public class UseLiked_Sys {

    class MyCircularDeque {
        int size,len;
        LinkedList<Integer> liked;
        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDeque(int k) {
            size=0;
            len=k;
            liked=new LinkedList();
        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
            if (isFull())return false;
            liked.addFirst(value);
            size++;
            return true;
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
            if (isFull())return false;
            liked.addLast(value);
            size++;
            return true;
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
            if (isEmpty())return false;
            liked.removeFirst();
            size--;
            return true;
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {
            if (isEmpty())return false;
            liked.removeLast();
            size--;
            return true;
        }

        /** Get the front item from the deque. */
        public int getFront() {
            if (isEmpty())return -1;
            return liked.getFirst();
        }

        /** Get the last item from the deque. */
        public int getRear() {
            if (isEmpty())return -1;
            return liked.getLast();
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return size==0;
        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            return size==len;
        }
    }
}
