package Recursive.ConstructBinaryTreefromPreorderandInorderTraversal105;

import java.util.ArrayDeque;
import java.util.HashMap;

public class Fail {
    /**
     * 思路：
     * 前提：你可以假设树中没有重复的元素。
     *
     * 从中序遍历中确定所有左子树的节点，和右子树的节点，存在map中标记k：值，v：l/r左右子树标记
     * 并且记录最左的节点值，和最右的节点值
     * 根据前序遍历，构建树
     * 判断当前节点的map的v是左还是右，以及和极左，极右节点的索引的关系
     *
     * 失败原因：极左节点的下一个节点是在他的右子树，还是兄弟节点的判断没考虑到
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,String> map = new HashMap<>();
        TreeNode root = new TreeNode(preorder[0]);
        int l_index=0,l_value=inorder[0];
        int r_index=0,r_value=inorder[inorder.length-1];
        int root_index=Integer.MAX_VALUE;
        for (int i=0;i<inorder.length;i++){
            if (inorder[i]==preorder[0])root_index=i;
            if (i<root_index){
                map.put(inorder[i],"left");
            }else {
                map.put(inorder[i],"right");
            }
        }
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        for (int i = 1; i < preorder.length; i++) {
            TreeNode pop = stack.pop();
            int current_val = preorder[i];
            if (current_val==l_value)l_index=i;
            TreeNode node = new TreeNode(current_val);
            if (map.get(current_val).equals("left")){
                pop.left=node;
            }else {
                pop.right=node;

            }
            if (pop.right==null)stack.push(pop);
            stack.push(node);
        }
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
