package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RightSideView {


    /**
     * 从顶部到底部的顺序，右侧看到的节点
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i =0;i<size;i++) {
                TreeNode top = queue.poll();
                if (i == size-1) result.add(top.val);
                if (top.left!=null) queue.add(top.left);
                if (top.right!=null) queue.add(top.right);
            }

        }
        return result;
    }
}
