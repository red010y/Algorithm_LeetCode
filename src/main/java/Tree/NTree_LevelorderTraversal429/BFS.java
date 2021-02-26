package Tree.NTree_LevelorderTraversal429;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 思路：
 * 给每层创建一个集合，从当前层获取下一层的所有节点加到下一层的集合中
 * 并把当前层的所有节点加到集合中
 */
public class BFS {

    public List<List<Integer>> levelOrder(Node root) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root==null)return result;
        List<Node> current = Arrays.asList(root);
//        while (current!=null){这个会超时的原因：集合的底层是数组，判断条件不是null，而是为0。isEmpty底层判断也是为0
        while (!current.isEmpty()){
            ArrayList<Integer> level = new ArrayList<Integer>();
            ArrayList<Node> next = new ArrayList<Node>();
            for (Node node:current){
                level.add(node.val);
                next.addAll(node.children);
            }
            result.add(level);
            current=next;
        }
        return result;
    }

    public List<List<Integer>> levelOrder2(Node root) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (root==null)return result;
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i=0;i<size;i++) {
                Node poll = queue.poll();
                list.add(poll.val);
//                List<Node> children = poll.children;
//                for (int i=0;i<children.size();i++){
//                    queue.add(children.get(i));
//                }
                queue.addAll(poll.children);
            }
            result.add(list);
        }
        return result;
    }

    static class Node{
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
