package Tree.NTree_PostorderTraversal590;

import java.util.ArrayList;
import java.util.List;

/**
 * 思路：
 * 找到最底层，之后遍历底层的节点，把每个节点加入到集合中
 * 递归
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

    public List<Integer> postorder(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        recursive(root,result);
        return result;
    }

    private void recursive(Node root, ArrayList<Integer> result) {
        if (root==null)return;
        if (root.children!=null) {
            for (Node n : root.children) {
                recursive(n, result);
            }
        }
        result.add(root.val);
    }



}
