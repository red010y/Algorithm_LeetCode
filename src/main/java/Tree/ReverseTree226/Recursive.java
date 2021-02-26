package Tree.ReverseTree226;



public class Recursive {
    /**
     * 思路：
     * 本质上就是左右节点互换
     * 从根节点开始，不断的向下递归，把每层的左右节点互换就可以
     */
    public TreeNode invertTree(TreeNode root) {
        recursive(root);
        return root;
    }

    private void recursive(TreeNode root) {
        if (root==null)return ;
        TreeNode tmp = root.right;
        root.right=root.left;
        root.left=tmp;
        recursive(root.left);
        recursive(root.right);
    }

    /**
     * 思路：
     * 本质上就是左右节点互换
     * 从叶子节点开始，互换，不断的向上递归
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root==null)return null;
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left=right;
        root.right=left;
        return root;
    }



    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val=val;
        }
    }
}
