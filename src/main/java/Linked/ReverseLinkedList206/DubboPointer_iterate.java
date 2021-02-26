package Linked.ReverseLinkedList206;

/**
 * 思路：
 * 设置两个指针，一个是pre，一个是current
 * 让current指向pre
 * 不断的移动pre和current，直到current==null
 */

public class DubboPointer_iterate {
    class ListNode{
        int value;
        ListNode next;
        public ListNode(int value){
            this.value=value;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre=null;
        ListNode current=head;
        while (current!=null){
            ListNode next = current.next;
            current.next=pre;
            pre=current;
            current=next;
        }
        return pre;
    }
}
