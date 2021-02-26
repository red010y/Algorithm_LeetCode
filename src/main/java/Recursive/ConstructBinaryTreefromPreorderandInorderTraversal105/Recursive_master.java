package Recursive.ConstructBinaryTreefromPreorderandInorderTraversal105;

/**
 * 光头哥原文：https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/discuss/34543/Simple-O(n)-without-map
 * preorder: [1, 2, 4, 5, 3, 6]
 * inorder: [4, 2, 5, 1, 6, 3]
 * 1.preorder的第一个元素1是根
 * 2.搜索中序
 * 3.通过中序分割成两部分[4,2,5]和[6,3]
 * 4.将前序遍历除根节点外的其余部分分为两部分，和中序遍历一样大。[2,4,5]和[3,6]
 * 5.使用preorder = [2, 4, 5] and inorder = [4, 2, 5] 添加左子树
 * 6.使用preorder =[3, 6] and inorder = [6, 3] 添加右子树
 *
 * 第一步：考虑最坏的情况，树退化成了链表，集中在左子树上。此时前序遍历的结果反转过来是中序的结果1234,4321
 * 第二步：在中序中查找，根据您如何“拆分”数组，您将可能看到，时间复杂度O(n^2) ，空间复杂度O（n^2）
 * 在开始主要工作之前，通过构建一个map，k是值，v是在中序中的索引位置，可以将搜索的运行时降到O（n），我已经看到几种解决方案可以做到这一点。
 * 但这是O（n）额外的空间，分裂问题仍然存在。要解决这些问题，可以在前序和中序中使用指针，而不是拆分它们。当你这么做的时候，你也不需要map索引的kv。
 *
 * 再考虑一下这个例子。不要在中序中找根，而是将数组分成几个部分并在它们上递归，只需在剩余的完整数组上递归，并在中序中遇到根时停止。这就是我上面的解决方案。
 * 它将自己的根值root.val作为stopper赋给它的左子树调用，将其父级的stopper作为stopper赋给它的右子树调用。
 */
public class Recursive_master {
    private int in = 0;
    private int pre = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, Integer.MIN_VALUE);
    }

    private TreeNode build(int[] preorder, int[] inorder, int stop) {
        if (pre >= preorder.length) return null;
        if (inorder[in] == stop) {
            in++;
            return null;
        }
        TreeNode node = new TreeNode(preorder[pre++]);
        node.left = build(preorder, inorder, node.val);
        node.right = build(preorder, inorder, stop);
        return node;
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
