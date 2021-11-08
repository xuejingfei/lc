package tree;

public class IsBalanced {


    /**
     * 时间复杂度O(n^2)
     * 空间复杂度O(n)
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(maxDepth(root.left) - maxDepth(root.right))<=1 && isBalanced(root.left) && isBalanced(root.right);
    }


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
        if (leftHeight == -1)return -1;
        int rightHeight = height(root.right);
        if (rightHeight ==-1) return -1;
        if (Math.abs(leftHeight-rightHeight)>1){
            return -1;
        }
        return Math.max(leftHeight,rightHeight)+1;
    }



}
