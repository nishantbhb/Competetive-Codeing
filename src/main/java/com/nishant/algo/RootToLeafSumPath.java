package com.nishant.algo;


import java.util.ArrayList;
import java.util.List;

class RootToLeafSumPath {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        if (root == null)
            return new ArrayList<>();
        return sum(root, 0, sum, new ArrayList<>(), new ArrayList<>());

    }

    private List<List<Integer>> sum(TreeNode root, int currSum, int sum, List<Integer> nodes, List<List<Integer>> sumList) {
        if (root.left == null && root.right == null && root.val + currSum == sum) {
            nodes.add(root.val);
            List<Integer> newList = new ArrayList<>(nodes);
            sumList.add(newList);
            if (!nodes.isEmpty())
                nodes.remove(nodes.size() - 1);
            return sumList;
        }
        nodes.add(root.val);
        currSum += root.val;
        if (root.left != null) {

            sum(root.left, currSum, sum, nodes, sumList);
        }
        if (root.right != null) {
            sum(root.right, currSum, sum, nodes, sumList);
        }
        if (!nodes.isEmpty())
            nodes.remove(nodes.size() - 1);

        return sumList;
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