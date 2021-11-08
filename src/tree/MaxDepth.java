package tree;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;

public class MaxDepth {

    /**
     * 获取二叉树的最大深度
     * 时间复杂度(O(n))
     * 空间复杂度(O(n))
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }


    /**
     * 层次遍历
     * @param root
     * @return
     */
    public int maxDepthByDfs(TreeNode root) {
        int ans = 0;
        if (root == null) return ans;
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root !=null) queue.add(root);
        LinkedList<TreeNode> temp;
        while (!queue.isEmpty()){
            temp = new LinkedList<>();
            for(TreeNode node:queue) {
                if (node.left!=null) temp.add(node.left);
                if (node.right!=null) temp.add(node.right);
            }
            queue = temp;
            ans++;
        }
        return ans;
    }




}
