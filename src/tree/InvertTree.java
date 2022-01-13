package tree;


import java.util.LinkedList;

public class InvertTree {


    /**
     * 反转二叉树(前序)
     * https://leetcode-cn.com/problems/invert-binary-tree/
     * @param root
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        swapLeftRight(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }


    /**
     * 反转二叉树（中序）
     * @param root
     */
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) return null;
        invertTree1(root.left);
        swapLeftRight(root);
        invertTree1(root.right);
        return root;
    }


    /**
     * 反转二叉树（后序)
     * @param root
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;
        invertTree2(root.left);
        invertTree2(root.right);
        swapLeftRight(root);
        return null;
    }


    /**
     * 层级遍历
     * @param root
     */
    public TreeNode invertTree3(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root!=null) queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            swapLeftRight(node);
            if (node.left!=null) queue.add(node.left);
            if (node.right!=null)queue.add(node.right);
        }

        return root;
    }


    /**
     * 深度遍历(前序)
     * @param root
     */
    public TreeNode invertTree4(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root!=null) stack.push(root);
        while (!stack.isEmpty()) {
             TreeNode node = stack.poll();
             swapLeftRight(node);
            if (node.left!=null) stack.add(node.left);
            if (node.right!=null)stack.add(node.right);
        }
        return root;
    }

    /**
     *  标记法
     * @param root
     * @return
     */
    public TreeNode invertTree5(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root != null) {
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode top = stack.poll();
                if (top != null) {
                    if (top.right!=null) stack.push(top.right);
                    stack.push(top);
                    stack.push(null);
                    if (top.left!=null)  stack.push(top.left); //左
                } else {
                    TreeNode node = stack.poll();
                    swapLeftRight(node);
                }
            }
        }
        return root;
    }

    /**
     * 替换左右树
     * @param root
     */
    public void swapLeftRight(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }




}
