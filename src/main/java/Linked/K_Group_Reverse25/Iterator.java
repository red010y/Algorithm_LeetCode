package Linked.K_Group_Reverse25;

/**
 * 思路：
 * 设置一个虚拟节点，指向head，方便返回结果。让虚拟节点赋值给pre和end
 * 设置start指向一组的头，设置end指向一组的尾。设置next指向下一组的头
 * 之后让pre指向反转后的当前组，start指向next
 * 之后start变为pre和end，next变为start
 * 迭代这个过程
 *
 *
 * 核心关键：
 * pre指向翻转后的头
 * start指向next
 */
public class Iterator {

    public class ListNode {
        int value;
        ListNode next;
        public ListNode(int value){
            this.value=value;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode pre=dummy;
        ListNode end =dummy;
        while (end.next!=null){
            for (int i=0;i<k&&end!=null;i++){
                end=end.next;
            }
            if (end==null)break;
            ListNode next = end.next;
            ListNode start = pre.next;
            end.next=null;
            pre.next=reverse(start);
            start.next=next;
            pre=start;
            end=pre;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode start) {
        ListNode pre=null;
        while (start!=null){
            ListNode next = start.next;
            start.next=pre;
            pre=start;
            start=next;
        }
        return pre ;
    }
}
