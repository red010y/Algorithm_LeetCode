package Linked.SwapNodesInPair24;

/**
 * 思路：
 * 进行递归的时候主要是寻找3个节点，head，heda.next，tail
 * 递归的找到最后一个奇数节点，或者null节点tail
 * head指向tail，next指向head，完成从后往前的一组的反转
 * 之后就是返回这组的头结点现在的next，让上一组继续递归这个过程
 */
public class ThreeNodes_Recursive {

    class ListNode {
        int value;
        ListNode next;
        ListNode(int value){
            this.value=value;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head==null||head.next==null)return head;
        ListNode next = head.next;
        ListNode tail = swapPairs(next.next);
        head.next=tail;
        next.next=head;
        return next;
    }

}
