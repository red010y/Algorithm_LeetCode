package Stack.CreateStack;

public class LinkedStack {
    private Node top=null;
    public void push(int value){
        Node newNode = new Node(value, null);
        if (top==null){
            top=newNode;
        }else {
            newNode.next=top;
            top=newNode;
        }
    }

    public int pop(){
        if (top==null)return -1;
        int value = top.data;
        top=top.next;
        return value;
    }

    public void printAll(){
        Node p=top;
        while (p!=null){
            System.out.print(p.data+" ");
            p=p.next;
        }
        System.out.println();
    }


    private static class Node{
        private int data;
        private Node next;

        public Node(int data,Node next){
            this.data=data;
            this.next=next;
        }

        public int getData(){
            return data;
        }

    }
}
