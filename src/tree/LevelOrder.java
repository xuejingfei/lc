package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrder {

    /**
     * 层次遍历
     * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root!=null) queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for(int i=0;i<size;i++) {
                TreeNode top = queue.poll();
                level.add(top.val);
                if (top.left!=null) queue.add(top.left);
                if (top.right!=null) queue.add(top.right);
            }
            ans.add(level);
        }
        return ans;
    }
}
