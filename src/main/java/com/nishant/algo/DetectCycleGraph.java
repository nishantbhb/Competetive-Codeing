package com.nishant.algo;

import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 *1->2->3
 *1->3
 *1->4
 */

class Node {


    int val;
    List<Node> neighbours = new ArrayList<>();
    Set<Node> visitedTillHere = new HashSet<>();

    Node(int x) {
        this.val = x;
    }
}

public class DetectCycleGraph {


    private static boolean checkLoop(Node root) {
        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();

        if (root == null)
            return false;

        stack.push(root);

        while (!stack.isEmpty()) {
            Node curr = stack.pop();

            for (Node neighbour : curr.neighbours) {

                if (!visited.contains(neighbour)) {


                    stack.push(neighbour);
                    visited.add(curr);

                }

                if (curr.visitedTillHere.contains(neighbour))
                    return true;
                neighbour.visitedTillHere.addAll(curr.visitedTillHere);
                neighbour.visitedTillHere.add(curr);


            }


        }
        return false;
    }


    public static void main(String[] args) {

        Node root = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);


        root.neighbours.add(two);
        root.neighbours.add(three);
        root.neighbours.add(four);
        two.neighbours.add(root);
        five.neighbours.add(two);

        System.out.println(checkLoop(root));

    }
}


