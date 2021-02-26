package Linked.LinkedListCycle141;

/**
 * 思路：
 * 快慢指针
 * 只要慢指针被追上就说明有循环
 */
public class dubbodPointer {

    class ListNode{
        int value;
        ListNode next;
        public ListNode(int value){
            this.value=value;
        }
    }

    public static boolean hasCycle(ListNode head) {
        if (head==null)return false;
        ListNode fast=head;
        ListNode slow=head;
        while (fast.next!=null&&fast.next.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow==fast)return true;
        }
        return false;
    }

}
