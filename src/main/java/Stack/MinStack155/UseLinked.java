package Stack.MinStack155;

/**
 * 思路：
 * 用链表实现stack
 * 链表中记录：当前值和min
 * push元素的时候，如果Node不存在，也就是第一个元素，最小值就他自己
 * 如果Node存在，新节点加入到链表头，指向链表。比较当前这个节点的值和min，在当前节点记录下当前状态的最小值
 * pop，当前的节点的下一个节点变成head，把当前节点赋值null，方便GC。(即使栈顶元素出栈，新的栈顶元素记录着当前状态的min值)
 * top直接返回head.value
 * getMin直接返回min
 */
public class UseLinked {

    class MinStack {

        class Node{
            int value;
            Node next;
            int min;
            public Node(int value,int min){
                this.value=value;
                this.min=min;
            }
        }

        Node head;
        /** initialize your data structure here. */
        public MinStack() {

        }

        public void push(int x) {
            if (head==null){
                head=new Node(x,x);
            }else {
                Node new_node=new Node(x,Math.min(x,head.min));
                new_node.next=head;
                head=new_node;
            }
        }

        public void pop() {
            if (head!=null) {
                Node new_head = head.next;
                head = null;
                head = new_head;
            }
        }

        public int top() {
            if (head!=null)return head.value;
            return -1;
        }

        public int getMin() {
            if (head!=null)return head.min;
            return -1;
        }
    }

}
