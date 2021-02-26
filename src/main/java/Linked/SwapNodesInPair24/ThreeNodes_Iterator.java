package Linked.SwapNodesInPair24;


/**
 * 思路：
 * 定义一个虚拟节点，让虚拟节点指向head.next。这里可以看做：pre是第一组指向第二组head和head.next的正确位置
 * 之后第二组中，后指向前，前指向.next.next
 * 之后head变成pre，head.next.next变成head（第二组的头）
 */
public class ThreeNodes_Iterator {

    class ListNode {
        int value;
        ListNode next;
        ListNode(int value){
            this.value=value;
        }
    }

    public ListNode swapPairs(ListNode head) {
        //我这是创建了一个节点，下面是让pre更改这个节点的指向，在循环中pre在不断的变换，而我们最后要的是dummy.next指向。不是pre（pre在不断变化）
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode pre=dummy;
        while (head!=null&&head.next!=null){
            ListNode next = head.next;
            ListNode tmp = head.next.next;
            pre.next=next;
            next.next=head;
            head.next=tmp;
            pre=head;
            head=tmp;
        }
        return dummy.next;
    }

}
