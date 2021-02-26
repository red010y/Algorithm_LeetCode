package Tree.NTree_PreorderTraversal589;


import java.util.*;

/**
 * 思路：
 * stack
 * 把每层的节点从右到左的顺序入栈
 */
public class UseStack {

    class Node{
        List<Node> children;
        int val;
        public Node(int val){
            this.val=val;
        }
        public Node(int val,List<Node> children){
            this.val=val;
            this.children=children;
        }
    }

    public List<Integer> preorder(Node root) {
        LinkedList<Integer> result = new LinkedList<Integer>();
        if (root==null)return result;
        ArrayDeque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node pop = stack.pop();
            result.add(pop.val);
            if (pop.children!=null) {
                Collections.reverse(pop.children);
                for (Node node : pop.children) {
                    stack.push(node);
                }
//            int size = pop.children.size();
//            for (int i=size-1;i>=0;i--){
//                stack.push(pop.children.get(i));
//            }
            }
        }
        return result;
    }


}
