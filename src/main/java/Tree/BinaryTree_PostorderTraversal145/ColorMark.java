package Tree.BinaryTree_PostorderTraversal145;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 思路：
 * 颜色标记，0是没走过，1是走过
 * 在栈中存放paris 0/1，node
 * 如果当前节点是没走过，按照根右左的顺序加入栈中
 */
public class ColorMark {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int data){
            this.val=data;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root==null)return result;
        ArrayDeque<Pair<Integer,TreeNode>> stack = new ArrayDeque<>();
        stack.push(new Pair<>(0,root));
        while (!stack.isEmpty()){
            Pair<Integer, TreeNode> pop = stack.pop();
            if (pop.getKey()==0) {
                stack.push(new Pair<>(1, pop.getValue()));
                if (pop.getValue().right!=null) stack.push(new Pair<>(0, pop.getValue().right));
                if (pop.getValue().left!=null) stack.push(new Pair<>(0, pop.getValue().left));
            }else {
                result.add(pop.getValue().val);
            }
        }
        return result;
    }



}
