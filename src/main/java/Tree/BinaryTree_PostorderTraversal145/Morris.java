package Tree.BinaryTree_PostorderTraversal145;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/discuss/45648/Three-ways-of-Iterative-PostOrder-Traversing.-Easy-Explanation!
 */
public class Morris {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        t1.left=t2;
        t1.right=t3;
        t2.right=t4;
        t4.left=t5;
        t4.right=t6;
        postorderTraversal(t1);
    }
    static class TreeNode{
        int val;
        TreeNode left,right;
        public TreeNode(int val){
            this.val=val;
        }
        public TreeNode(TreeNode left, TreeNode right, int val){
            this.left=left;
            this.right=right;
            this.val=val;
        }
    }
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        TreeNode dummy = new TreeNode(-1);
        TreeNode pre = null;
        dummy.left = root;
        root = dummy;
        while (root!=null){
            if (root.left!=null){
                pre = root.left;
                while(pre.right != null && pre.right != root)
                    pre=pre.right;
                if(pre.right == null){
                    pre.right = root;
                    root = root.left;
                } else{
                    TreeNode node = pre;
                    reverse(root.left,pre);
                    while(node != root.left){
                        result.add(node.val);
                        node = node.right;
                    }
                    result.add(node.val);          // Print again since we are stopping at node=root.left
                    reverse(pre,root.left);
                    pre.right = null;
                    root = root.right;
                }
            }else {
                root=root.right;
            }
        }
        return result;
    }

    public static void reverse(TreeNode rootLeft, TreeNode pre){
        if(rootLeft == pre)
            return;
        TreeNode prev = rootLeft, node = rootLeft.right;
        while(prev != pre){
            TreeNode next = node.right;
            node.right = prev;
            prev = node;
            node = next;
        }
    }


}
