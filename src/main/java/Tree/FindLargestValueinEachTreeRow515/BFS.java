package Tree.FindLargestValueinEachTreeRow515;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 思路：
 * dequeue中存放每层的所有元素
 * 从每层元素中找出max
 */
public class BFS {
    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root==null)return result;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            int max=Integer.MIN_VALUE;
            while (size-->0) {
                TreeNode poll = queue.poll();
                max=Math.max(poll.val,max);
                if (poll.left!=null)queue.offer(poll.left);
                if (poll.right!=null)queue.offer(poll.right);
            }
            result.add(max);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t3 = new TreeNode(3);
        TreeNode t2 = new TreeNode(2);
        TreeNode t9 = new TreeNode(9);
        TreeNode t5 = new TreeNode(5);
        TreeNode t33 = new TreeNode(3);
        t1.left=t3;
        t1.right=t2;
        t2.right=t9;
        t3.left=t5;
        t3.right=t33;
        new BFS().largestValues(t1);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
