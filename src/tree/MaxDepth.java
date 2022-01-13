package tree;


import java.util.LinkedList;

public class MaxDepth {

    /**
     * 获取二叉树的最大深度
     * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
     * 时间复杂度(O(n))
     * 空间复杂度(O(height))
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
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     * @param root
     * @return
     */
    public int maxDepthByDfs(TreeNode root) {
        int ans = 0;
        if (root == null) return ans;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i<size;i++) {
                TreeNode node = queue.pop();
                if (node.left!=null) queue.offer(node.left);
                if (node.right!=null) queue.offer(node.right);
            }
            ans++;
        }
        return ans;
    }




}
