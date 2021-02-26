package Tree.BinaryTree_PreorderTraversal144;

import java.util.ArrayList;
import java.util.List;

/**
 * 思路：
 * 递归
 */
public class Recursive {

    class TreeNode{
        int val;
        TreeNode left,right;
        public TreeNode(int val){
            this.val=val;
        }
        public TreeNode(TreeNode left,TreeNode right,int val){
            this.left=left;
            this.right=right;
            this.val=val;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        recursive(root,result);
        return result;
    }

    private void recursive(TreeNode root, ArrayList<Integer> result) {
        if (root==null)return;
        result.add(root.val);
        recursive(root.left,result);
        recursive(root.right,result);
    }

}
