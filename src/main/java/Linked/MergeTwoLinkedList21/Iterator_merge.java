package Linked.MergeTwoLinkedList21;

/**
 * 思路：
 * 新建一个节点
 * 一直往前遍历2个链表
 * 比较l1和l2的值，新链表指向值小的那个节点
 * 如果一个链表走完了，直接把另一个链表加过去
 */
public class Iterator_merge {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int val){
            this.val=val;
        }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while (l1!=null&&l2!=null){
            if (l1.val>l2.val){
                head.next=l2;
                head=l2;
                l2=l2.next;
            }else {
                head.next=l1;
                head=l1;
                l1=l1.next;
            }
        }
        head.next=l1==null?l2:l1;
        return dummy.next;
    }
}
