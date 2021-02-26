package Tree.BinaryTree_LevelOrderTraversal102;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 思路：
 * 把当前层移除队列，把下一层的节点都放入队列中
 * 并把下一层的值放入集合，最后将一层的元素值，放入result
 */
public class BFS {

    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (root==null)return result;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> list= new ArrayList<>();
            while (size!=0) {
                TreeNode  poll = queue.poll();
                list.add(poll.val);
                if (poll.left!=null)queue.add(poll.left);
                if (poll.right!=null)queue.add(poll.right);
                size--;
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        BFS bfs = new BFS();
        //[3,9,20,null,null,15,7]
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);
        t1.left=t2;
        t1.right=t3;
        t3.left=t4;
        t3.right=t5;

        new BFS().levelOrder(t1);
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
