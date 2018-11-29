package Petuum;

public class DeleteNode {
    class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
            left = null;
            right = null;
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void delete(Node node, int start, int end) {
        if (node == null) {
            return;
        }
        delete(node.left, start, end);
        delete(node.right, start, end);
        if (isLeaf(node)&&(node.val < start || node.val > end)){
            node = null;
        }
    }

    public boolean isLeaf(Node node) {
        if (node.left == null && node.right == null) {
            return true;
        }
        return false;
    }
}
