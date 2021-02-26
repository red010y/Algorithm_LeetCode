package Tree.LowestCommonAncestorofaBinaryTree236;

import java.util.HashMap;
import java.util.HashSet;

public class Iterator {
    /**
     * 思路：
     * map中存当前节点，最近的祖先
     * set中存祖先
     *
     * 遍历所有节点，在map中存放子父关系
     * 获取map中p节点所有的父亲节点，存放在set中
     * 查看set，如果没有q（说明q有两种情况。第一种：q节点在p的下面。第二种：p,q不在根节点的同一侧）
     * 获取q的所有父亲节点，直到找到p。如果最后到了根还没找到。那说明p,q不在根节点的同一侧
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        recursive(root,map);
        HashSet<TreeNode> set = new HashSet<>();
        while (p!=null){
            set.add(p);
            //root的父亲节点在map中不存在，返回null
            p = map.get(p);
        }
        while (!set.contains(q)){
            //不断的更新q，如果在set中存在了q说明就是p（q节点在p的下面，在set中找到q，此时的q就是p）。
            //如果在set中最后到了根，那说明p,q不在根节点的同一侧。仍然返回q就是此时的root
            q=map.get(q);
        }
        return q;
    }

    private void recursive(TreeNode root, HashMap<TreeNode, TreeNode> map) {
        if (root==null)return;
        if (root.left!=null)map.put(root.left,root);
        if (root.right!=null)map.put(root.right,root);
        recursive(root.left, map);
        recursive(root.right, map);
    }

    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(TreeNode left, TreeNode right, int val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }
    }
}
