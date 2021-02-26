package Tree.LowestCommonAncestorofaBinaryTree236;

/**
 * 思路：
 * 公共祖先可能的3种情况：
 * 左子树上p/q
 * 右子树上p/q
 * 根节点
 *
 * 因为是递归，使用函数后可认为左右子树已经算出结果
 * 如果root为null返回null，左右子树一旦找到一个pq就返回节点
 * 不断的递归左右子树
 * 如果左子树为null，则公共节点在右子树上，若右子树为null反之。
 * 如果左右子树都不为null（左子树找到p，或者是q。或者是右子树）返回根节点
 */
public class Recursive {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null||root==p||root==q)return root;
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        return left==null?right:right==null?left:root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
