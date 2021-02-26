

public class LinkedTest {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val=x;
        }
    }

    public static ListNode init1(){
        ListNode list1=new ListNode(1);
        ListNode list2=new ListNode(2);
        ListNode list3=new ListNode(3);
        ListNode list4=new ListNode(4);
        ListNode list5=new ListNode(5);
        list1.next=list2;
        list2.next=list3;
        list3.next=list4;
        list4.next=list5;
        return list1;
    }
    public static ListNode init2(){
        ListNode list1=new ListNode(1);
        ListNode list2=new ListNode(3);
        ListNode list3=new ListNode(4);
        list1.next=list2;
        list2.next=list3;
        return list1;
    }
}
