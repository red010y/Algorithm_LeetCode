package Tree.BinaryTree_PreorderTraversal144;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 思路：
 * 关键：走过变换颜色
 *
 * 颜色标记
 * 创建栈，栈中存放Pair对象，key是颜色0代表没有遍历，1代表已经遍历，value是节点
 * 判断颜色:
 * 0：按照右左根的顺序加入到栈中，根要标记1
 * 1：加入到结果集
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

    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root==null)return result;
        ArrayDeque<Pair<Integer, TreeNode>> stack = new ArrayDeque<>();
        stack.push(new Pair<>(0,root));
        while (!stack.isEmpty()){
            Pair<Integer, TreeNode> pop = stack.pop();
            if (pop.getKey()==0){
                if (pop.getValue().right!=null)stack.push(new Pair<>(0,pop.getValue().right));
                if (pop.getValue().left!=null)stack.push(new Pair<>(0,pop.getValue().left));
                stack.push(new Pair<>(1,pop.getValue()));
            }else {
                result.add(pop.getValue().val);
            }
        }
        return result;
    }



}
