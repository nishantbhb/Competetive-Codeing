package com.nishant.algo;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class MaxPathSum {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxSumHelper(root);

        return maxSum;
    }

    private int maxSumHelper(TreeNode root) {
        if (root == null)
            return 0;

        int leftSum = maxSumHelper(root.left);
        int rightSum = maxSumHelper(root.right);

        int sumWithRoot = Math.max(root.val, root.val + Math.max(leftSum, rightSum));
        int sumIncludingRoot = Math.max(sumWithRoot, root.val + leftSum + rightSum);


        maxSum = Math.max(maxSum, sumIncludingRoot);

        return Math.max(root.val, root.val + Math.max(leftSum, rightSum));
    }
}


