package com.nishant.algo;


import java.util.List;
import java.util.Set;
import java.util.Stack;

//for multiple entry point to graph - pass a list of root rather than single root and iterate topologicalSort for all
class Solution {

    public static void main(String[] args) {
        /*Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        root.neighbors = List.of(a, b);
        Node c = new Node(4);
        //Node d = new Node(5);
        a.neighbors = Collections.singletonList(c);
        b.neighbors = Collections.singletonList(c);

        Stack<Integer> integers = topologicalSort(root, new HashSet<>(), new Stack<>());
        while (!integers.isEmpty()) {
            System.out.println(integers.pop());
        }*/

    }

    private Stack<Integer> topologicalSort(Node node, Set<Node> visited, Stack<Integer> topo) {
        if (node == null)
            return topo;

        List<Node> neighbours = node.neighbors;
        visited.add(node);
        if (neighbours == null) {
            topo.push(node.val);

            return topo;
        }
        for (Node curr : neighbours) {
            if (visited.contains(curr))
                continue;
            topologicalSort(curr, visited, topo);
        }
        topo.push(node.val);

        return topo;
    }

    private class Node {
        public int val;
        public List<Node> neighbors;

        public Node(int val) {
            this.val = val;
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }


}