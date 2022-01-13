package tree;

import java.util.*;

public class InOrderTraversal {

    /**
     * 中序排列
     * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @return
     */
    public List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inOrderTraversal(root,ans);
        return ans;
    }


    public void inOrderTraversal(TreeNode root,List<Integer> ans) {
        if (root == null) return;
        inOrderTraversal(root.left,ans);
        ans.add(root.val);
        inOrderTraversal(root.right,ans);
    }


    /**
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     * @param root
     * @return
     */
    public List<Integer> inOrderTraversal1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        if (root !=null) stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            if (top !=null) {
                if (top.right!=null) stack.push(top.right);
                stack.push(top);
                stack.push(null);
                if (top.left!=null) stack.push(top.left);
            } else {
                TreeNode node = stack.pop();
                ans.add(node.val);
            }
        }
        return ans;
    }



}
