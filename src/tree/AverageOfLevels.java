package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AverageOfLevels {

    /**
     * 求层级的平均值
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.offer(root);
        double sum = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0;i<size;i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left!=null) queue.offer(node.left);
                if (node.right!=null)queue.offer(node.right);
            }
            double average = sum/size;
            sum = 0;
            ans.add(average);
        }
        return ans;
    }
}
