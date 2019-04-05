package com.nishant.algo;

/*
Input: [1,2,3]
    1
   / \
  2   3
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
 */

class SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {

        return sum(root, 0, new Counter(0));

    }

    private int sum(TreeNode root, int num, Counter total) {
        if (root.left == null && root.right == null) {
            num *= 10;
            num += root.val;
            total.total += num;
        }
        if (root.left != null) {
            int leftNum = num * 10 + root.val;
            sum(root.left, leftNum, total);
        }
        if (root.right != null) {
            int rightNum = num * 10 + root.val;
            sum(root.right, rightNum, total);
        }
        return total.total;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Counter {
        int total;

        Counter(int total) {
            this.total = total;
        }
    }


}