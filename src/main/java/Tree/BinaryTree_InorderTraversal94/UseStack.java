package Tree.BinaryTree_InorderTraversal94;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 思路：
 * 移动当前节点，入栈，直到走到最左。
 * 最左的值加入节点到结果集，之后继续移动当前节点走右边节点
 */
public class UseStack {
    class TreeNode{
        int val;
        TreeNode left,right;
        public TreeNode(int val){
            this.val=val;
        }
        public TreeNode(TreeNode left,TreeNode right,int val){
            this.left=left;
            this.right=right;
            this.val=val;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            TreeNode pop = stack.pop();
            result.add(pop.val);
            root=pop.right;
        }
        return result;
    }
}
