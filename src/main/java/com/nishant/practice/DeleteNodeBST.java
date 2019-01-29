package com.nishant.practice;

class TreeBuilder {
    TreeNode buildTree() {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(3);
        treeNode.left.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(4);
        treeNode.right = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        return treeNode;
    }

    TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        if (root.val == key) {
            if (root.left == null && root.right == null)
                root = null;
            else if (root.left == null)
                root = root.right;
            else if (root.right == null)
                root = root.left;
            else {
                System.out.println("here");
                TreeNode curr = root.right;
                while (curr.left != null)
                    curr = curr.left;
                root.val = curr.val;
                root.right = deleteNode(root.right, key);
            }

        } else if (root.val > key)
            root.left = deleteNode(root.left, key);
        else
            root.right = deleteNode(root.right, key);

        return root;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

public class DeleteNodeBST {
    public static void main(String[] args) {
        TreeBuilder treeBuilder = new TreeBuilder();
        TreeBuilder.TreeNode treeNode = treeBuilder.buildTree();
        TreeBuilder.TreeNode root = treeBuilder.deleteNode(treeNode, 3);
        System.out.println(root.val);
    }
}