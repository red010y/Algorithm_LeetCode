package Tree.BinaryTree_PostorderTraversal145;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 思路：
 * 关键：记录右侧节点是否走过 走到极左 判断右侧节点
 *
 * 先走到极左
 * 之后判断是否有右侧节点
 * 没有，加入结果集，记录当前节点为右子树，用来判断是否走过右侧，root赋值为null
 * 有，root赋值为root.right
 */
public class UseStack {
    static class TreeNode {
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

    public static List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        //保证右侧不会走第二遍
        TreeNode right_record=null;
        while (!stack.isEmpty()||root!=null){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            TreeNode pop = stack.pop();
            if (pop.right==null||pop.right==right_record){
                result.add(pop.val);
                //记录右子树，用来标记是否走过右侧
                right_record=pop;
            }else {
                //重新放回
                stack.push(pop);
                root=pop.right;
            }
        }
        return result;
    }
}
