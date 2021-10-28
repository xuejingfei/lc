package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ZigzagLevelOrder {

    /**
     * Z字型打印二叉树
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        LinkedList<TreeNode> temp;
        boolean isRvert = false;
        while(!queue.isEmpty()) {
            temp = new LinkedList<TreeNode>();
            List<Integer> level = new ArrayList<>();
            for(int i = 0;i<queue.size();i++) {
                TreeNode node = queue.get(i);
                if(isRvert) {
                    TreeNode revertNode = queue.get(queue.size() - i-1);
                    level.add(revertNode.val);
                } else {
                    level.add(node.val);
                }
                if(node.left !=null) {
                    temp.add(node.left);
                }
                if(node.right!=null) {
                    temp.add(node.right);
                }
            }
            ans.add(level);
            isRvert = !isRvert;
            queue = temp;
        }

        return ans;
    }
}
