package Tree.BinaryTree_SerializeandDeserialize297;

import java.util.ArrayDeque;
import java.util.LinkedList;

/**
 * 思路：
 * 序列化：当前节点的左右节点不断的入队
 * 反序列化：
 * 从根节点开始，遍历String
 * 根据我们序列化的特点，当前节点的左节点：2*n+1，右节点：2*n+2
 * 当前的i就是左节点的位置，++i就是右节点的位置
 * 不断的入队左右节点
 */
public class UseQueue {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder res = new StringBuilder();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if (poll==null){
                res.append("null ");
                continue;
            }
            res.append(poll.val+" ");
            queue.add(poll.left);
            queue.add(poll.right);
        }
        return res.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals(""))return null;
        String[] vals = data.split(" ");
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.valueOf(vals[0]));
        queue.offer(root);
        for (int i=1;i<vals.length;i++){
            TreeNode poll = queue.poll();
            if (!vals[i].equals("null")){
                TreeNode left = new TreeNode(Integer.valueOf(vals[i]));
                queue.offer(left);
                poll.left=left;
            }
            if (!vals[++i].equals("null")){
                TreeNode right = new TreeNode(Integer.valueOf(vals[i]));
                queue.offer(right);
                poll.right=right;
            }
        }
        return root;
    }

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
        new UseQueue().deserialize(new UseQueue().serialize(t1));
        System.out.println();
    }

}
