package Tree.NTree_PostorderTraversal590;

import java.util.*;

/**
 * 思路：
 *
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


    /**
     * 思路：
     * 用ArrayList实现
     * 根右左入栈，每次把children赋值为null，没有children加入到结果集
     */
    public static List<Integer> postorder(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root==null)return result;
        ArrayDeque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node pop = stack.pop();
            if (pop.children!=null){
                stack.push(pop);
                Collections.reverse(pop.children);
                for (Node n:pop.children){
                    stack.push(n);
                }
                pop.children=null;
            }else {
                result.add(pop.val);
            }
        }
        return result;
    }


    /**
     * 思路：
     * 用ArrayList实现
     * 根右左记录，之后反转结果集
     */
    public List<Integer> postorder2(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while(!stack.isEmpty()) {
            root = stack.pop();
            result.add(root.val);
            for(Node node: root.children)
                stack.add(node);
        }
        //根右左反转后成为左右根
        Collections.reverse(result);
        return result;
    }


    /**
     * 思路：
     * 用LinkedList实现
     * 链表实现,根右左加入链表的头部
     */
    public List<Integer> postorder3(Node root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root==null)return result;
        ArrayDeque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node pop = stack.pop();
            result.offerFirst(pop.val);
            for (Node n:pop.children){
                stack.push(n);
            }
        }
        return result;
    }

}
