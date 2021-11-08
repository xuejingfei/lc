package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InOrderTraversal {

    /**
     * 中序排列
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @return
     */
    public List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inOrderTraversal(root,ans);
        return ans;
    }

    public void inOrderTraversal(TreeNode root,List<Integer> list) {
        if (root == null) return;
        inOrderTraversal(root.left);
        list.add(root.val);
        inOrderTraversal(root.right);
    }


    public List<Integer> inOrderTraversal1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root !=null) stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            if (top!=null) {
                stack.push(top);
                stack.push(null);
                if (top.right !=null) stack.push(top.right);
                if (top.left !=null) stack.push(top.left);
            } else {
                TreeNode node = stack.pop();
                ans.add(node.val);
            }
        }
        return ans;
    }



}
