package Tree.ValidateBinarySearchTree98;

import java.util.ArrayList;


public class InOrder {

    /**
     * 思路：
     * 二叉搜索树的中序遍历是有序的
     * 先进行中序遍历，之后遍历中序结果看是否有序
     */
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inOrderRecursive(root,list);
        for (int i=1;i<list.size();i++){
            if (list.get(i)<=list.get(i-1))return false;
        }
        return true;
    }

    private void inOrderRecursive(TreeNode root, ArrayList<Integer> list) {
        if (root==null)return;
        inOrderRecursive(root.left,list);
        list.add(root.val);
        inOrderRecursive(root.right,list);
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
