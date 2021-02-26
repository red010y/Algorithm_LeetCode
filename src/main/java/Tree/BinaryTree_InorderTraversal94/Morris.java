package Tree.BinaryTree_InorderTraversal94;

import java.util.ArrayList;
import java.util.List;

/**
 * 思路：
 * 把树变成链表
 * 按照中序遍历的顺序进行转换：
 * 先找到第一个左子树，之后找到他最右的叶子结点，指向根节点
 * 以此类推
 * 如果左子树是null，就排好了我们要的链表，之后向右遍历就是要的结果
 */
public class Morris {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t1.left=t2;
        t1.right=t3;
        t2.right=t4;
        t4.left=t5;
        inorderTraversal(t1);
    }

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

    public static List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        while (root != null) {
            if (root.left != null) {
                TreeNode tail = root.left;
                while (tail.right != null && tail.right != root) tail = tail.right;
                if (tail.right==null){
                    tail.right=root;
                    root=root.left;
                }else {
                    //根据链表往回找的时候把值加入result(之前找极左的时候都没有添加，直到极左后往回找)
                    result.add(root.val);
                    root=root.right;
                }
            } else {
                result.add(root.val);
                root = root.right;
            }
        }
        return result;
    }
}
