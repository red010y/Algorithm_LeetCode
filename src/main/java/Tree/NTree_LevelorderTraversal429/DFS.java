package Tree.NTree_LevelorderTraversal429;

import java.util.ArrayList;
import java.util.List;

/**
 * 思路：
 * 递归，记录当前的层级
 * 只要当前的层级大于等于了，当前结果集的长度就创建一个ArrayList
 * 之后获取当前层级的ArrayList，加入当前元素
 * 递归
 */
public class DFS {
    public List<List<Integer>> levelOrder(Node root) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        recursive(root,result,0);
        return result;
    }

    private void recursive(Node root, ArrayList<List<Integer>> result, int level) {
        if (root==null)return;
        if (level>=result.size()){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        for (Node n:root.children){
            recursive(n,result,level+1);
        }
    }

    class Node{
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
