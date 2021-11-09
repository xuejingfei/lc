package tree;

import java.util.LinkedList;
import java.util.List;

public class LargestValues {


    /**
     * 记录每一层的最大值
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root!=null) queue.offer(root);
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0;i<size;i++) {
                TreeNode node = queue.poll();
                max = Math.max(node.val,max);
                if (node.left!=null) queue.offer(node.left);
                if (node.right!=null) queue.offer(node.right);
            }
            ans.add(max);
            max = Integer.MIN_VALUE;
        }
        return ans;
    }
}
