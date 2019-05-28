package com.nishant.algo;

public class DiameterOfBinaryTree {
    int maxDia = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter(root);
        return maxDia;
    }

    private int maxDiameter(TreeNode root) {
        if (root == null)
            return 0;
        int left = maxDiameter(root.left);
        int right = maxDiameter(root.right);

        maxDia = Math.max(maxDia, left + right);//not adding 1 since it's calculating edges in diameter
        return 1 + Math.max(left, right);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
