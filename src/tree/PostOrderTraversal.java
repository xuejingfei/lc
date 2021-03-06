package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PostOrderTraversal {


    /**
     * 后序递归
     * @param root
     * @return
     */
    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postOrderTraversal(root,ans);
        return ans;
    }


    public void postOrderTraversal(TreeNode root,List<Integer> ans) {
        if (root==null) {
            return;
        }
        postOrderTraversal(root.left,ans);
        postOrderTraversal(root.right,ans);
        ans.add(root.val);
    }



    public List<Integer> postOrderTraversal1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root !=null) stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.poll();
            if (top !=null) {
                stack.push(top);
                stack.add(null);//中
                if (top.right!=null) stack.add(top.right);//右
                if (top.left!=null) stack.add(top.left);//左
            } else {
                TreeNode node = stack.poll();
                ans.add(node.val);
            }
        }
        return ans;
    }


}
