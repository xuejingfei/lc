package tree;

public class KthLargestSearchTree {

    int count = 0;
    int target = -1;


    /**
     * 二叉搜索树的第k大节点
     * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root,int k) {
        this.count = k;
        traversal(root);
        return target;
    }

    public void traversal(TreeNode root) {
        if (root == null) return;
        traversal(root.right);
        if (--count == 0) {
            target = root.val;
            return;
        }
        traversal(root.left);
    }


}
