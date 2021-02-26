package Linked.K_Group_Reverse25;

/**
 * 思路：
 * 递归的找到最后一组，如果最后一组的长度不够k就返回最后一组的头tail
 * 用上一组的头（head）指向下一组的头（也就是tail），之后head.next变为head，head变为tial
 * 重复这个过程直到这一组都反转了，最后返回这一组新的头
 */
public class Recursive {


    public class ListNode {
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tail=head;
        int count=0;
        for (;count<k&&tail!=null;count++)tail=tail.next;
        if (count != k)return head;
        else {
            tail=reverseKGroup(tail,k);
            while (count-->0){
                ListNode next = head.next;
                head.next=tail;
                tail=head;
                head=next;
            }
            return tail;
        }
    }
}




