package tree;

public class MaxPathSum {
    int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        maxGain(root);
        return maxPathSum;
    }


    /**
     * 最大贡献值
     * @param root
     * @return
     */
    public int maxGain(TreeNode root) {
        if (root == null) return 0;
        int leftGain = Math.max(0,maxGain(root.left));
        int rightGain = Math.max(0,maxGain(root.right));
        int max = leftGain + rightGain + root.val;
        maxPathSum = Math.max(maxPathSum,max);
        return root.val + Math.max(leftGain,rightGain);
    }
}
