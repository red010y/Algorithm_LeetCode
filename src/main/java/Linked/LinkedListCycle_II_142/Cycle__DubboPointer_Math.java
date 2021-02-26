package Linked.LinkedListCycle_II_142;

/**
 * 思路：
 * 先让两个指针相遇
 * 之后让快指针从头开始一步步走
 * 再次相遇的时候就是进入循环的节点
 * 死记住这个结论，这是通过验算推导出来的。
 */
public class Cycle__DubboPointer_Math {

    class ListNode {
        int value;
        ListNode next;
        public ListNode(int value){
            this.value=value;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while (true){
            if (fast==null||fast.next==null)return null;
            fast=fast.next.next;
            slow=slow.next;
            if (fast==slow)break;
        }
        fast=head;
        while (fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return fast;
    }

    public ListNode detectCycle2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        do{
            if (fast==null||fast.next==null)return null;
            fast=fast.next.next;
            slow=slow.next;
        }while  (fast!=slow);
        fast=head;
        while (fast!=slow){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}
