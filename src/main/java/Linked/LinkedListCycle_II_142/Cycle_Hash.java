package Linked.LinkedListCycle_II_142;

/**
 * 思路：
 * 遍历链表，存入hash，如果走到头，没有环返回null
 * 如果走过的节点存在了hash中，返回这个节点
 */

import java.util.HashSet;

public class Cycle_Hash {

    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head!=null){
            if (set.contains(head))return head;
            set.add(head);
            head=head.next;
        }
        return null;
    }

    class ListNode {
        int value;
        ListNode next;
        public ListNode(int value){
            this.value=value;
        }
    }
}
