import java.util.*;

/**
 * 思路：
 * 记录当前层的队列长度
 * 取出当前层的所有元素加入到集合，并且把当前层的children加入到队列
 */
public class Test_NTree {

    static class Node{
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

    public static void main(String[] args) {
        ArrayList<Node> children1 = new ArrayList<>();
        ArrayList<Node> children2 = new ArrayList<>();
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        children2.add(node5);
        children2.add(node6);
        Node node3 = new Node(3,children2);
        Node node2 = new Node(2);
        Node node4 = new Node(4);
        children1.add(node3);
        children1.add(node2);
        children1.add(node4);
        Node node1 = new Node(1,children1);
        new Test_NTree().levelOrder(node1);
    }

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


}
