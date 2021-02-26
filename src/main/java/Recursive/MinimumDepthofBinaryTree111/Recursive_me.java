package Recursive.MinimumDepthofBinaryTree111;

/**
 * 思路：
 * 寻找叶子节点，如果左右节点都是null就是叶子节点和全局变量min比较
 */
public class Recursive_me {

    int min=Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if (root==null)return 0;
        recursive(root,1);
        return min;
    }

    private void recursive(TreeNode root, int depth) {
        if (root==null)return;
        if (root.left==null&root.right==null)min=Math.min(min,depth);
        recursive(root.left, depth + 1);
        recursive(root.right, depth + 1);
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
