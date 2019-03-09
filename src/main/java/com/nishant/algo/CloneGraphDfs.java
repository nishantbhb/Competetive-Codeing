package com.nishant.algo;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
    }

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraphDfs {


    static public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        Map<Node, Node> nodeMap = new HashMap<>();
        Set<Node> visited = new HashSet<>();
        Stack<Node> dfs = new Stack<>();
        dfs.push(node);
        visited.add(node);
        while (!dfs.isEmpty()) {
            Node curr = dfs.pop();
            Node clone = new Node();
            clone.val = curr.val;
            nodeMap.put(curr, clone);

            if (curr.neighbors == null)
                continue;
            //visit children
            for (Node neighbour : curr.neighbors) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    dfs.push(neighbour);
                }
            }
        }

        Node root = nodeMap.get(node);
        visited = new HashSet<>();
        dfs.push(node);
        visited.add(node);

        while (!dfs.isEmpty()) {
            Node curr = dfs.pop();
            Node newCurr = nodeMap.get(curr);


            if (curr.neighbors == null)
                continue;


            List<Node> neighbours = new ArrayList<>();

            //visit children
            for (Node neighbour : curr.neighbors) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    dfs.push(neighbour);
                }
                neighbours.add(nodeMap.get(neighbour));
            }
            newCurr.neighbors = neighbours;
        }

        return root;
    }


    public static void main(String[] args) {
        Node node = new Node();
        node.val = 1;
        Node nod1 = new Node();
        nod1.val = 2;
        Node nod2 = new Node();
        nod2.val = 3;
        Node nod3 = new Node();
        nod3.val = 4;

        List<Node> neighbors = new ArrayList<>();
        neighbors.add(nod1);
        neighbors.add(nod3);
        node.neighbors = neighbors;

        neighbors = new ArrayList<>();
        neighbors.add(nod2);
        neighbors.add(node);
        nod1.neighbors = neighbors;

        neighbors = new ArrayList<>();
        neighbors.add(nod1);
        neighbors.add(nod3);
        nod2.neighbors = neighbors;

        neighbors = new ArrayList<>();
        neighbors.add(nod2);
        neighbors.add(node);
        nod3.neighbors = neighbors;

        System.out.println(cloneGraph(node));

    }

}