package Recursive.MinimumDepthofBinaryTree111;

/**
 * 思路：
 * 先递归的走到叶子结点
 * 左右子树有一个为null，或者全为null，返回left+right子树的深度+1（一个节点是null，深度只能取另外一个）
 * 若左右子树都不为null，返回最小的那个子树的深度+1（保证取的是左右子树中深度最小的）
 */
public class Recursive_master {
    public int minDepth(TreeNode root) {
        if (root==null)return 0;
        int l_depth = minDepth(root.left);
        int r_depth = minDepth(root.right);
        return (l_depth==0||r_depth==0)?l_depth+r_depth+1:Math.min(l_depth,r_depth)+1;
    }
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int data){
            this.val=data;
        }
    }
}
