package Tree.ValidateBinarySearchTree98;


/**
 * 思路：
 * 必须考虑全部节点这个关键问题。所以当前节点一定要满足，小于最大的，大于最小的
 * 递归left，当前节点是最大的，右边当前节点是最小的（这样就能避免，只考虑父亲节点的左右节点大小关系）
 * [5,4,6,null,null,3,7]
 */
public class Recursive {

    public boolean isValidBST(TreeNode root) {
        return recursive(root,null,null);
    }

    private boolean recursive(TreeNode root, Integer max, Integer min) {
        if (root==null)return true;
        int val = root.val;
        if (max!=null&&val>=max)return false;
        if (min!=null&&val<=min)return false;
        if (!recursive(root.left,val,min))return false;
        if (!recursive(root.right,max,val))return false;
        return true;
    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int data){
            this.val=data;
        }
    }

    public static void main(String[] args) {
        TreeNode t5 = new TreeNode(5);
        TreeNode t4 = new TreeNode(4);
        TreeNode t6 = new TreeNode(6);
        TreeNode t3 = new TreeNode(3);
        TreeNode t7= new TreeNode(7);
        t5.left=t4;
        t5.right=t6;
        t6.left=t3;
        t6.right=t7;
        new Recursive().isValidBST(t5);
    }

}
