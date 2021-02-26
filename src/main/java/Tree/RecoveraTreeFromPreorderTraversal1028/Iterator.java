package Tree.RecoveraTreeFromPreorderTraversal1028;


import java.util.Stack;

/**
 * 思路：
 * 在栈中存放元素
 * 统计-数量，记录level和pos
 * -数量和当前栈中元素相等，作为左子树
 * 如果不等作为右子树
 * 入栈
 * 最后将栈中元素出栈，留下最后一个节点就是我们要的根节点
 */
public class Iterator {
    public TreeNode recoverFromPreorder(String S) {
        Stack<TreeNode> stack = new Stack<>();
        int pos=0;
        while (pos<S.length()){
            int level=0;
            while (S.charAt(pos)=='-'){
                pos++;
                level++;
            }
            int value=0;
            while (S.length()>pos&&S.charAt(pos)!='-'){
                value=value*10+(S.charAt(pos)-'0');
                pos++;
            }
            TreeNode root = new TreeNode(value);
            if (stack.size()==level){
                if (!stack.isEmpty()){
                    stack.peek().left=root;
                }
            }else {
                while (stack.size()!=level){
                    stack.pop();
                }
                stack.peek().right=root;
            }
            stack.push(root);
        }
        while (stack.size()>1){
            stack.pop();
        }
        return stack.peek();
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
