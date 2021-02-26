package Tree.BinaryTree_InorderTraversal94;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 思路：
 * 颜色标记，0是没走过，1是走过
 * 在栈中存放paris 0/1，node
 * 如果当前节点是没走过，按照右根左的顺序加入栈中
 */
public class ColorMark {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t1.left=t2;
        t1.right=t5;
        t2.left=t3;
        t2.right=t4;
        List<Integer> result = inorderTraversal(t1);
        for (int i:result){
            System.out.println(i);
        }
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root==null)return result;
        ArrayDeque<Pair<Integer,TreeNode>> stack = new ArrayDeque<>();
        stack.push(new Pair<>(0,root));
        while (!stack.isEmpty()){
            Pair<Integer, TreeNode> pop = stack.pop();
            if (pop.getKey()==0) {
                if (pop.getValue().right != null) stack.push(new Pair<>(0, pop.getValue().right));
                stack.push(new Pair<>(1, pop.getValue()));
                if (pop.getValue().left != null) stack.push(new Pair<>(0, pop.getValue().left));
            }else {
                result.add(pop.getValue().val);
            }
        }
        return result;
    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int data){
            this.val=data;
        }
    }

}
