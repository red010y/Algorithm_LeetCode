package Tree.BinaryTree_SerializeandDeserialize297;

import java.util.Arrays;

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
public class Recursive_me {

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

        t1.right=t2;
        t2.right=t3;
        t3.right=t4;
        t4.right=t5;
        new Recursive_me().deserialize(new Recursive_me().serialize(t1));

    }
    static Object[] arr = new Object[16];
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root==null)return "[]";
        StringBuilder res = new StringBuilder();
        recursive(root,0);
        res.append("[");
        int index=0;
        for (int i=arr.length-1;i>=0;i--){
            if (arr[i]!=null){
                index=i;
                break;
            }
        }
        for (int i=0;i<=index;i++){
            if (arr[i]!=null){
                if (i==index)
                    res.append(arr[i]);
                else
                    res.append(arr[i]+",");
            }
            else res.append("null"+",");
        }
        res.append("]");
        return String.valueOf(res);
    }

    private void recursive(TreeNode root, int index) {
        while (index>=arr.length)grow();
        if (root==null){
            arr[index]=null;
            return;
        }
        arr[index]=root.val;
        recursive(root.left,index*2+1);
        recursive(root.right,index*2+2);
    }

    private void grow() {
        int oldCapacity = arr.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        // minCapacity is usually close to size, so this is a win:
        arr=Arrays.copyOf(arr, newCapacity);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data=="[]")return null;
        TreeNode root = new TreeNode((Integer) arr[0]);
        buildTree(root,0);
        return root;
    }

    private void buildTree(TreeNode root, int i) {
        if (root==null)return;

        if (arr[i * 2 + 1]==null)
            root.left = null;
        else
            root.left = new TreeNode((Integer) arr[i * 2 + 1]);
        if (arr[i * 2 + 2]==null)
            root.right = null;
        else
            root.right = new TreeNode((Integer) arr[i * 2 + 2]);

        buildTree(root.left,i*2+1);
        buildTree(root.right,i*2+2);
    }


}
