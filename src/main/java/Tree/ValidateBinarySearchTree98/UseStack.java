package Tree.ValidateBinarySearchTree98;

import java.util.ArrayDeque;

public class UseStack {
    /**
     * 思路：
     * 当前节点有左节点就不断的入栈，找到最左，就是最小的值
     * 如果当前值小于最小值返回false
     * 迭代这个过程，直到栈为null
     */
    public boolean isValidBST(TreeNode root) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        double inorder=-Double.MAX_VALUE;
        while (!stack.isEmpty()||root!=null){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            if (root.val<=inorder)return false;
            inorder=root.val;
            root=root.right;
        }
        return true;
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
