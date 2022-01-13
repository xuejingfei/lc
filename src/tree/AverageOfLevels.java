package tree;

import java.util.*;

public class AverageOfLevels {

    /**
     * 求层级的平均值
     * https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
       List<Double> ans = new ArrayList<>();
       if (root == null) return ans;
       Queue<TreeNode> queue = new LinkedList<>();
       queue.offer(root);
       while (!queue.isEmpty()) {
           int size = queue.size();
           double sum = 0;
           for (int i=0;i<size;i++) {
               TreeNode node = queue.poll();
               sum+=node.val;
               if (node.left!=null) queue.offer(node.left);
               if (node.right!=null) queue.offer(node.right);
           }
           ans.add(sum /size);
       }
       return ans;
    }
}
