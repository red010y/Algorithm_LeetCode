package Linked.ReverseLinkedList206;

/**
 * 思路：
 * 让下一个节点next指向上一个节点current，之后next就变成current，继续这个循环
 * head节点指向head.next.next,直到head.next为null
 */
public class DubboPointer_iterate_other {
    class ListNode{
        int value;
        ListNode next;
        public ListNode(int value){
            this.value=value;
        }
    }


    public ListNode reverseList(ListNode head) {
        if (head==null)return head;
        ListNode current=head;
        while (head.next!=null){
            ListNode tmp = head.next.next;
            head.next.next=current;
            current=head.next;
            head.next=tmp;
        }
        return current;
    }
}
