package Tree.BinaryTree_InorderTraversal94;

import java.util.ArrayList;
import java.util.List;

/**
 * 思路：
 * 先找到最左的，之后加入到结果中。在找最左的这个的右节点，之后递归这个过程
 */
public class Recursive {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        recursive(list,root);
        return list;
    }

    private void recursive(List<Integer> list, TreeNode root) {
        //Terminated
        if (root==null)return;
        //process current logic
        recursive(list,root.left);
        list.add(root.val);
        recursive(list,root.right);
        //drill down
        //reset state
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
