package Petuum;

public class HouseRobber3 {
    public int rob(TreeNode root) {
        int[] res = robs(root);
        return Math.max(res[0], res[1]);

    }

    public int[] robs(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] left = robs(root.left);
        int[] right = robs(root.right);
        int[] res = new int[2];

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }
}
