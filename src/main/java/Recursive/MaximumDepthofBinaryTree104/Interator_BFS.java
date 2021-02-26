package Recursive.MaximumDepthofBinaryTree104;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 思路：
 * 队列不是null就一直BFS
 * 每次把当前层的所有节点都放入queue，之后进入下一层count++
 */
public class Interator_BFS {
    public int maxDepth(TreeNode root) {
        int count=0;
        if (root==null)return count;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-- >0){
                TreeNode poll = queue.poll();
                if (poll.left!=null)queue.offer(poll.left);
                if (poll.right!=null)queue.offer(poll.right);
            }
            count++;
        }
        return count;
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.val = data;
        }
    }
}
