package Linked.MergeTwoLinkedList21;



/**
 * 思路：
 * 递归，每层找到最小的，指向下一个小的（递归的在去找小的）
 * 如果走完了一个链条，直接返回另外一个链条就是最终的结果
 */
public class Recursive_merge {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int val){
            this.val=val;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null)return l2;
        if (l2==null)return l1;
        if (l1.val>l2.val){
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        }else {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
    }

}
