package tree;

public class KSmallestSearchTree {

    int target = -1;
    int count;

    /**
     * 二叉搜索树中第K小的元素
     * @param root
     * @param k
     * @return
     */
    public int kSmallest(TreeNode root, int k) {
        count = k;
        inOrderTraversal(root);
        return target;
    }


    public void inOrderTraversal(TreeNode node) {
        if (node == null)
            return;
        //访问左子节点
        inOrderTraversal(node.left);
        //访问当前节点，如果访问到第k个就把target赋值
        if (--count == 0) {
            target = node.val;
            return;
        }
        //访问右子节点
        inOrderTraversal(node.right);
    }

}
