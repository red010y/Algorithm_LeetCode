package Tree.BinaryTree_LevelOrderTraversal102;

import java.util.ArrayList;
import java.util.List;

/**
 * 思路：
 * 如果节点为null返回
 * 每到一层new一个list
 * 将当前层的值放入list
 * 接着走左右子树
 */
public class DFS {

    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        recursive(root,result,0);
        return result;
    }

    private void recursive(TreeNode root, ArrayList<List<Integer>> result, int level) {
        if (root==null)return;
        //有多少层，new多少list
        if (level>=result.size()){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        recursive(root.left,result,level+1);
        recursive(root.right,result,level+1);
    }

    public static void main(String[] args) {
        //[3,9,20,null,null,15,7]
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);
        t1.left=t2;
        t1.right=t3;
        t3.left=t4;
        t3.right=t5;
        DFS dfs = new DFS();
        dfs.levelOrder(t1);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
