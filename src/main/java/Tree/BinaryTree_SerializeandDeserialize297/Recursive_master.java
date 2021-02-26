package Tree.BinaryTree_SerializeandDeserialize297;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 思路：
 * 二叉树的序列化本质上是对其值进行编码
 * 所以不是说必须返回 "[1,2,3,null,null,4,5]"。
 * 比如这个方法实际返回：1,2,null,null,3,4,null,null,5,null,null
 *
 * 序列化：遍历树,将遍历的结果放入String中，null就加入"null "
 * 反序列化：将String切割，放入队列中。不断的出队，如果null就返回null。如果不是就创建节点,之后创建其左右节点，最后返回当前节点
 */
public class Recursive_master {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int data){
            this.val=data;
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

        t3.left=t4;
        t3.right=t5;
        new Recursive_master().deserialize(new Recursive_master().serialize(t1));
        System.out.println();
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return recursive(root, "");
    }

    private String recursive(TreeNode root, String s) {
        if (root==null)return s+="null ";
        s+=root.val+" ";
        s=recursive(root.left,s);
        s=recursive(root.right,s);
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(" ");
        LinkedList<String> queue = new LinkedList<>(Arrays.asList(vals));
        return build_tree(queue);
    }

    private TreeNode build_tree(LinkedList<String> queue) {
        String poll = queue.poll();
        if (poll.equals("null"))return null;
        TreeNode node = new TreeNode(Integer.valueOf(poll));
        node.left=build_tree(queue);
        node.right=build_tree(queue);
        return node;
    }


}
