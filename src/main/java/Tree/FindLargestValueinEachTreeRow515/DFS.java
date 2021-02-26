package Tree.FindLargestValueinEachTreeRow515;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 思路：
 * map中存放：key当期层，value当前层的最大值
 * 如果是新的一层就往map中存放map.put(level,Integer.MIN_VALUE);
 * 不断递归左右节点，直到节点为null
 */
public class DFS {
    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        dfs(root,0,map);
        result.addAll(map.values());
        return result;
    }

    private void dfs(TreeNode root, int level, HashMap<Integer, Integer> map) {
        if (root==null)return;
        if (level>=map.size()){
            map.put(level,Integer.MIN_VALUE);
        }
        map.put(level,Math.max(map.get(level),root.val));
        dfs(root.left, level+1, map);
        dfs(root.right, level+1, map);
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
