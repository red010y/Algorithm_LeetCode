package Linked.ReverseLinkedList206;

/**
 * 思路：
 * 递归的寻找尾节点，之后进行反转，后面的节点指向当前节点，当前节点指向null
 */
public class Recursive {
    class ListNode{
        int value;
        ListNode next;
        public ListNode(int value){
            this.value=value;
        }
    }


    public ListNode reverseList(ListNode head) {
        if (head==null||head.next==null)return head;
        //tail是最后结果的头指针
        ListNode tail = reverseList(head.next);
        head.next.next=head;
        head.next=null;
        //只需要找到tail就好，反转不能在tail上反转。否则会变为5->4,5->3。。。5->1
        return tail;
    }
}
