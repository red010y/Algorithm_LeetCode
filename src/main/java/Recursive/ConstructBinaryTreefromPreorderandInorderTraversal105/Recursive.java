package Recursive.ConstructBinaryTreefromPreorderandInorderTraversal105;

import java.util.HashMap;

/**
 * 思路：
 *      1
 *    2   3
 *  4  5 6  7
 *
 * 前序：1245 367
 * 中序：425 1 637
 *
 * 根据中序遍历我们可以知道根节点的位置，以及根节点的左子树和右子树各有多少个节点：425 1 637
 * 在知道左子树和右子树个数的情况下，我们就能在前序遍历中找到左子树和右子树的起点和终点
 * 之后递归的设置左右子树
 *
 * 左子树
 * 前序：根+1 到 根+左子树个数+1。--1245
 * 中序：i_start 到 根的位置。--425 1
 *
 * 右子树
 * 前序：根+移动的位置+1 到 结束的位置。--367
 * 中序：根+1 到 结束的位置--637
 */
public class Recursive {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return recursive(preorder,0, preorder.length,inorder,0,inorder.length);
    }

    private TreeNode recursive(int[] preorder, int p_start, int p_end, int[] inorder, int in_start, int in_end) {
        if (p_start==p_end)return null;
        TreeNode root = new TreeNode(preorder[p_start]);
        int in_root_index=0;
        for (int i=in_start;i<in_end;i++){
            if (inorder[i]==preorder[p_start]){
                in_root_index=i;
                break;
            }
        }
        int leftNum=in_root_index-in_start;
        root.left=recursive(preorder,p_start+1,p_start+leftNum+1,inorder,in_start,in_root_index);
        root.right=recursive(preorder,p_start+leftNum+1,p_end,inorder,in_root_index+1,in_end);
        return root;
    }



    /**
     * 思路：
     * 本题有一个前提条件，假设树中没有重复元素，所以可以采用map来存储中序遍历的值
     * 前序的p_start就是根，从中序中就可以划分左右子树
     * 记录中序中移动的位置，之后就可以划分了
     */
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return recursive2(preorder,0,preorder.length,inorder,0,inorder.length,map);

    }

    private TreeNode recursive2(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end, HashMap<Integer, Integer> map) {
        if (p_start==p_end)return null;
        int root_val = preorder[p_start];
        TreeNode root = new TreeNode(root_val);
        int i_root_index = map.get(root_val);
        int leftNum = i_root_index - i_start;
        root.left=recursive2(preorder,p_start+1,p_start+leftNum+1,inorder,i_start,i_root_index,map);
        root.right=recursive2(preorder,p_start+leftNum+1,p_end,inorder,i_root_index+1,i_end,map);
        return root;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.val = data;
        }
    }



}
