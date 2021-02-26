package Queue.CreateQueue;

/**
 * 思路：
 * 链表实现
 * offer入队：如果的第一个节点，赋值给head和tail。如果不是，tail指向该节点，新节点变为tail
 * poll出队：head出队，并更新head
 */
public class Linked_queue {
    public static void main(String[] args) {
        Linked_queue queue = new Linked_queue();
        queue.offer("1");
        queue.offer("2");
        String poll = queue.poll();
        System.out.println(poll);//1
    }

    class Node{
        String value;
        Node next;
        public Node(String value){
            this.value=value;
        }
    }

    Node head,tail;
    public void offer(String s){
        if(tail==null){
            Node current=new Node(s);
            head=current;
            tail=current;
        }else {
            tail.next=new Node(s);
            tail=tail.next;
        }
    }

    public String poll(){
        if (head==null)return null;
        String value = head.value;
        head=head.next;
        if (head==null)tail=null;
        return value;
    }
}
