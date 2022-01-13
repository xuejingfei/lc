package tree;

import java.util.*;

public class ZigzagLevelOrder {

    /**
     * Z字型打印二叉树
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isRevert = false;
        while(!queue.isEmpty()) {
            LinkedList<Integer> level = new LinkedList<>();
            int size = queue.size();
            for(int i = 0;i<size;i++) {
                TreeNode node = queue.poll();
                if(isRevert) level.addFirst(node.val); else level.add(node.val);
                if(node.left !=null)  queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            ans.add(level);
            isRevert = !isRevert;
        }

        return ans;
    }
}
