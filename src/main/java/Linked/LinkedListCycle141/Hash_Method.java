package Linked.LinkedListCycle141;

import java.util.HashSet;

/**
 * 思路：
 * 暴力法，遍历链表
 * 把链表放入set集合中，一旦有重复就能用方法判断出来
 */
public class Hash_Method {

    class ListNode{
        int value;
        ListNode next;
        public ListNode(int value){
            this.value=value;
        }
    }


    public static boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head!=null){
            if (set.contains(head))return true;
            set.add(head);
            head=head.next;
        }
        return false;
    }

}
