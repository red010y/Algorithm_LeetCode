package Tree.BinaryTree_PreorderTraversal144;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 思路：
 * 关键：stack 移动节点 极左
 *
 * stack
 * 核心思路：穷举完左边所有节点，穷举的过程中添加根节点的值到result。在走右边节点，同样的套路穷举左边
 *
 * 把根节点放入栈，并在result中存放。
 * 之后循环的走根节点的左节点，之后不断的在栈中加入根节点，结果集中加入他的值，并把左节点赋值给root。
 * 走完左的所有情况后，出栈根节点，走根的右节点，循环这个过程
 */
public class UseStack {

    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty()||root!=null){
            while (root!=null){
                list.add(root.val);
                stack.push(root);
                root=root.left;
            }
            root=stack.pop().right;
        }
        return list;
    }
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int data){
            this.val=data;
        }
    }
}
