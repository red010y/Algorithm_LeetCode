package Tree.BinaryTree_PreorderTraversal144;

import java.util.ArrayList;
import java.util.List;

/**
 * 思路：
 * 关键：构建链表 移动节点 左1极右指向当前节点
 *
 * 莫里斯
 * 核心思路：
 * 把树按照前序遍历转换为链表
 *
 * root节点按照前序遍历的顺序移动
 * 找到当前节点的左节点最右的节点tail
 * 如果tail的右指针是null，让这个节点的右指针指向当前节点。结果集中加入当前节点，并且移动当前节点root到left
 * 如果tail的右指针不是null，说明左边都遍历完了，root指向右边，遍历右边。
 * 左边遍历完，把当前节点加入到结果集，root指向右边，遍历右边。
 */
public class Morris {

    static class TreeNode{
        int val;
        TreeNode left,right;
        public TreeNode(int val){
            this.val=val;
        }
        public TreeNode(TreeNode left,TreeNode right,int val){
            this.left=left;
            this.right=right;
            this.val=val;
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
        t2.right=t4;
        t4.left=t5;
        preorderTraversal(t1);
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        while (root!=null){
            if (root.left!=null){
                TreeNode tail = root.left;
                while (tail.right!=null&&tail.right!=root)tail=tail.right;
                if (tail.right==null){
                    //构建链表
                    tail.right=root;
                    result.add(root.val);
                    root=root.left;
                }else {
                    //根据链表往回找
                    root=root.right;
                }
            }else {
                //最左节点的值
                result.add(root.val);
                root=root.right;
            }
        }
        return result;
    }

}
