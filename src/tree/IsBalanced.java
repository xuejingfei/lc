package tree;

public class IsBalanced {


    /**
     * 平衡二叉树
     * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
     * https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
     * 时间复杂度O(n^2)
     * 空间复杂度O(n)
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(maxDepth(root.left) - maxDepth(root.right))<=1 && isBalanced(root.left) && isBalanced(root.right);
    }


    /**
     * 求二叉树的高度
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }


    /**
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     * @param root
     * @return
     */
    public boolean isBalanced1(TreeNode root) {
        return height(root)>=0;
    }

    public int height(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1|| rightHeight == -1|| Math.abs(leftHeight-rightHeight) >1) {
            return -1;
        }
        return Math.max(leftHeight,rightHeight)+1;
    }



}
