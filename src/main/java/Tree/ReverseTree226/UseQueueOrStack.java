package Tree.ReverseTree226;

import java.util.ArrayDeque;
import java.util.LinkedList;

/**
 * 思路：
 * 把root放入队列，队列不为null，一直迭代
 * 之后互换其左右，只要左右节点存在就入队
 */
public class UseQueueOrStack {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val=val;
        }
    }

    public TreeNode invertTree_queue(TreeNode root) {
        if (root == null) return null;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            TreeNode left = poll.left;
            poll.left=poll.right;
            poll.right=left;
            if (poll.left!=null)queue.offer(poll.left);
            if (poll.right!=null)queue.offer(poll.right);
        }
        return root;
    }

    public TreeNode invertTree_stack(TreeNode root) {
        if (root==null)return root;
        ArrayDeque<TreeNode> stak = new ArrayDeque<>();
        stak.push(root);
        while (!stak.isEmpty()){
            TreeNode pop = stak.pop();
            TreeNode tmp = pop.left;
            pop.left=pop.right;
            pop.right=tmp;
            if (pop.left!=null)stak.push(pop.left);
            if (pop.right!=null)stak.push(pop.right);
        }
        return root;
    }


}
