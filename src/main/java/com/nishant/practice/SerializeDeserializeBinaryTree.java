package com.nishant.practice;

import java.util.Arrays;
import java.util.LinkedList;

public class SerializeDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return null;

        LinkedList<String> nodeList = new LinkedList<>();

        LinkedList<TreeNode> levelQueue = new LinkedList<>();
        levelQueue.add(root);

        int height = maxDepth(root);

        while (!levelQueue.isEmpty()) {
            int levelSize = levelQueue.size();
            while (levelSize != 0) {
                TreeNode curr = levelQueue.remove();
                levelSize--;

                if (curr != null) {
                    nodeList.add(Integer.toString(curr.val));

                    if (curr.left != null)
                        levelQueue.add(curr.left);
                    else if (height > 1)// leaf node of max depth
                        levelQueue.add(null);


                    if (curr.right != null)
                        levelQueue.add(curr.right);
                    else if (height > 1)// leaf node of max depth
                        levelQueue.add(null);

                } else {
                    nodeList.add("null");
                    /*if (height > 1){
                        levelQueue.add(null);//left child
                        levelQueue.add(null);//right child
                    }*/
                }

            }
            height--;
        }

        return String.join(",", nodeList);
    }

    private int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null)
            return null;

        LinkedList<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        TreeNode rootNode = new TreeNode(Integer.parseInt(nodes.remove()));

        LinkedList<TreeNode> rootNodes = new LinkedList<>();
        rootNodes.add(rootNode);
        while (!rootNodes.isEmpty() && !nodes.isEmpty()) {
            TreeNode curr = rootNodes.remove();
            String left = nodes.remove();
            String right = nodes.remove();

            if (curr != null) {
                if (!left.equals("null")) {
                    curr.left = new TreeNode(Integer.parseInt(left));
                    rootNodes.add(curr.left);
                }
                /*else{
                    rootNodes.add(null);
                }*/

                if (!right.equals("null")) {
                    curr.right = new TreeNode(Integer.parseInt(right));
                    rootNodes.add(curr.right);
                }
                /*else{
                    rootNodes.add(null);
                }*/
            }
            /*else{
                rootNodes.add(null);//left
                rootNodes.add(null);//right
            }*/
        }
        return rootNode;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


}