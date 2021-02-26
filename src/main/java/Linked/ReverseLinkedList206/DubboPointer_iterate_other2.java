package Linked.ReverseLinkedList206;

/**
 * 思路：
 * 后指向前，最后让head指向null
 */
public class DubboPointer_iterate_other2 {

    class ListNode{
        int value;
        ListNode next;
        public ListNode(int value){
            this.value=value;
        }
    }

    //Error - Found cycle in the ListNode
    //12345变为543212345...因为循环中一直没有改变head的指向
    public ListNode reverseList_error(ListNode head) {
        if (head==null)return head;
        ListNode curr = head;
        ListNode next = head.next;
        while (next!=null){
            ListNode tmp = next.next;
            next.next=curr;
            curr=next;
            next=tmp;
        }
        return curr;
    }


    public ListNode reverseList(ListNode head) {
        if (head==null)return head;
        ListNode curr = head;
        ListNode next = head.next;
        while (next!=null){
            ListNode tmp = next.next;
            next.next=curr;
            curr=next;
            next=tmp;
        }
        //只要让这个环最后指向null就完事了
        head.next=null;
        return curr;
    }
}
