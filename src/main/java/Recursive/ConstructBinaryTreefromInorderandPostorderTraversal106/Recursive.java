package Recursive.ConstructBinaryTreefromInorderandPostorderTraversal106;
/**
 * 思路：
 *      1
 *    2   3
 *  4  5 6  7
 *
 * 中序:425 1 637
 * 后序:452 673 1
 *
 * 根据中序遍历我们可以知道根节点的位置，以及根节点的左子树和右子树各有多少个节点：425 1 637
 * 在知道左子树和右子树个数的情况下，我们就能在后序遍历中找到左子树和右子树的起点和终点
 * 之后递归的设置左右子树
 */
public class Recursive {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return recursive(inorder,0,inorder.length,postorder,0,postorder.length);
    }

    private TreeNode recursive(int[] inorder, int in_start, int in_end, int[] postorder, int p_start, int p_end) {
        if (p_start==p_end)return null;
        TreeNode root= new TreeNode(postorder[p_end-1]);
        int in_root_index = 0;
        for(int i=in_start;i<in_end;i++){
            if (root.val==inorder[i]){
                in_root_index=i;
                break;
            }
        }
        int leftNum=in_root_index-in_start;
        //这要注意，p_end取值p_start+leftNum
        root.left=recursive(inorder,in_start,in_root_index,postorder,p_start,p_start+leftNum);
        root.right=recursive(inorder,in_root_index+1,in_end,postorder,p_start+leftNum,p_end-1);
        return root;
    }
    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(TreeNode left, TreeNode right, int val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }
    }
}
