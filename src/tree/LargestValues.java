package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValues {


    /**
     * 记录每一层的最大值
     * https://leetcode-cn.com/problems/hPov7L/
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root!=null) queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i=0;i<size;i++) {
                TreeNode node = queue.poll();
                max = Math.max(max,node.val);
                if (node.left!=null) queue.offer(node.left);
                if (node.right!=null)queue.offer(node.right);
            }
            ans.add(max);
        }
        return ans;
    }
}
