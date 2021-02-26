package Recursive.MaximumDepthofBinaryTree104;



public class Recursive {

    /**
     * 思路
     * 遍历树
     * 不断的递归，记录左右节点的深度，返回其中最大的
     */
    public int maxDepth(TreeNode root) {
        int maxDepth = recursive(root, 1);
        return maxDepth;
    }

    private int recursive(TreeNode root, int maxDepth) {
        if (root == null) return maxDepth-1;
        int l_max = recursive(root.left, maxDepth + 1);
        int r_max = recursive(root.right, maxDepth + 1);
        return Math.max(l_max, r_max);
    }



    /**
     * 思路：
     * 获取左右节点中深度最大的那个
     * 到了叶子节点0,0返回1
     * 递归这个过程
     */
    public int maxDepth2(TreeNode root) {
        if (root==null)return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth,rightDepth)+1;
    }



    /**
     * 思路
     * 全局max，记录当前depth
     * 比较depth max
     */
    int max;
    public int maxDepth3(TreeNode root) {
        recursive2(root,1);
        return max;
    }

    private void recursive2(TreeNode root, int depth) {
        if (root==null)return;
        max=depth>max?depth:max;
        recursive2(root.left,depth+1);
        recursive2(root.right,depth+1);
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
