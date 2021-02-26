import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 思路：
 * 序列化：遍历树，把树的形态存入到数组中
 * 反序列化：从根节点开始递归的构建树
 *
 * 用到的技巧：
 * 1.基本类型的数组不能存放null，object[]
 * 2.数组长度不够，动态扩容
 * 3.扩容的时候怎么让传入的数组扩容，把数组设置成全局的，扩容后赋值。就可以解决参数是引用的问题
 */
public class Test_BinaryTree {


    public List<Integer> largestValues2(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root==null)return result;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            int max=Integer.MIN_VALUE;
            while (size-->0) {
                TreeNode poll = queue.poll();
                max=Math.max(poll.val,max);
                if (poll.left!=null)queue.offer(poll.left);
                if (poll.right!=null)queue.offer(poll.right);
            }
            result.add(max);
        }
        return result;
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

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);

        t1.left=t2;
        t1.right=t3;

        t2.left=t4;
        t2.right=t5;
        int[] inorder={4,2,5,1,6,3,7};
        int[] postorder={4,5,2,6,7,3,1};
        new Test_BinaryTree();

    }





}
