package tree;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversal {


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



    public void postOrderTraversal1(TreeNode root) {

    }


}
