package Petuum;

public class BSTDeleteNode {
    class TreeNode{
        int val;
        TreeNode left, right;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.val == key) {
            return deleteNode(root);
        } else if (key < root.val){
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    private TreeNode deleteNode(TreeNode root) {
        if (root.left == null) {
            return root.right;
        }
        if(root.right==null)
            return root.left;
        TreeNode curNode = root.left;
        while (curNode.right != null) {
            curNode = curNode.right;
        }
        curNode.right = root.right;
        return root.left;
    }
    public TreeNode deleteNode2(TreeNode root, int key) {
        TreeNode target = root, parent = null;
        while (target != null && target.val != key) {
            parent = target;
            if (key > target.val) target = target.right;
            else target = target.left;
        }
        if (target == null) return root;  // not found
        if (target.right == null) {  // no right subtree
            if (parent == null) return target.left;
            if (target == parent.left) parent.left = target.left;
            else parent.right = target.left;
            return root;
        }
        TreeNode prev = target, p = target.right;
        while (p.left != null) {
            prev = p;
            p = p.left;
        }
        target.val = p.val;
        if (p == prev.left) prev.left = p.right;
        else prev.right = p.right;
        return root;
    }
}
