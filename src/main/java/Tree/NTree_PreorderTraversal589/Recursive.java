package Tree.NTree_PreorderTraversal589;

import java.util.ArrayList;
import java.util.List;

/**
 * 思路：
 * 先把当前节点加到结果集中
 * 之后看每层的节点是否有children，有就继续进行递归
 */
public class Recursive {
    class Node{
        List<Node> children;
        int val;
        public Node(int val){
            this.val=val;
        }
        public Node(int val,List<Node> children){
            this.val=val;
            this.children=children;
        }
    }

    public List<Integer> preorder(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        recursive(result,root);
        return result;
    }

    private void recursive(ArrayList<Integer> result, Node root) {
        if (root==null)return;
        result.add(root.val);
        if (root.children!=null) {
            for (Node n : root.children) {
                recursive(result, n);
            }
        }
    }
}
