package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {


    /**
     * 前序遍历(递归)
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param root
     * @return
     */
    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        perOrderTraversal(root,ans);
        return ans;

    }

    public void perOrderTraversal(TreeNode root,List<Integer> ans) {
        if (root == null) return;
        ans.add(root.val);
        perOrderTraversal(root.left,ans);
        perOrderTraversal(root.right,ans);
    }


    /**
     * 使用栈
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param root
     * @return
     */
    public List<Integer> preOrderTraversal1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.add(node.val);
            if (node.right!=null) stack.push(node.right);
            if (node.left !=null) stack.push(node.left);
        }
        return ans;
    }
}
