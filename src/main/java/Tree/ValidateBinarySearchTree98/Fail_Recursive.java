package Tree.ValidateBinarySearchTree98;

/**
 * 失败原因：
 * 二叉搜索树定义：左子树全部小于父亲节点，右子树全部大于父亲节点。关键在全部！！！！
 * 这个写法就没考虑全部：5,4,6,null,null,3,7
 */
public class Fail_Recursive {

    public boolean isValidBST(TreeNode root) {
        if (root==null)return true;
        boolean l_boolean=true,r_boolean=true;
        if (root.left!=null) {
            if (root.val > root.left.val) {
                l_boolean = isValidBST(root.left);
            } else {
                return false;
            }
        }
        if (root.right!=null) {
            if (root.val < root.right.val) {
                r_boolean = isValidBST(root.right);
            } else {
                return false;
            }
        }
        return l_boolean&r_boolean;
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
