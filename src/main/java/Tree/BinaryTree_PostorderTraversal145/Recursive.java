package Tree.BinaryTree_PostorderTraversal145;


import java.util.ArrayList;
import java.util.List;

public class Recursive {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        recursive(root,result);
        return result;
    }

    private void recursive(TreeNode root, ArrayList<Integer> result) {
        if (root==null)return;
        recursive(root.left,result);
        recursive(root.right,result);
        result.add(root.val);
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
