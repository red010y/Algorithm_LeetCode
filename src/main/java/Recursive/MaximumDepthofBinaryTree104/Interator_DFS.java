package Recursive.MaximumDepthofBinaryTree104;

import javafx.util.Pair;

import java.util.Stack;

/**
 * 思路：
 * stack中存放map，map中存放节点，深度
 * 每入一层深度+1
 * 之后和最大深度比较
 */
public class Interator_DFS {
    public int maxDepth(TreeNode root) {
        int max=0;
        if (root==null)return max;
        Stack<Pair<Integer, TreeNode>> stack = new Stack<>();
        stack.push(new Pair<>(1,root));
        while (!stack.empty()){
            Pair<Integer, TreeNode> pop = stack.pop();
            Integer depth = pop.getKey();
            root = pop.getValue();
            max=Math.max(depth,max);
            if (root.left!=null)stack.push(new Pair<>(depth+1,root.left));
            if (root.right!=null)stack.push(new Pair<>(depth+1,root.right));
        }
        return max;
    }
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int data){
            this.val=data;
        }
    }
}
