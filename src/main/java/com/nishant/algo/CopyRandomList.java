package com.nishant.algo;


import java.util.HashMap;
import java.util.Map;

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {
    }

    public Node(int _val, Node _next, Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}


public class CopyRandomList {
    static Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Map<Node, Integer> origPos = new HashMap<>();
        Map<Integer, Node> newPos = new HashMap<>();
        Node ptr = head;
        Node newHead = new Node();
        newHead.val = head.val;
        Node temp = newHead;
        ptr = ptr.next;
        origPos.put(head, 1);
        newPos.put(1, newHead);
        int pos = 2;
        while (ptr != null) {
            origPos.put(ptr, pos);
            temp.next = new Node();
            temp = temp.next;
            temp.val = ptr.val;
            newPos.put(pos, temp);
            ptr = ptr.next;
            pos++;
        }
        temp = newHead;
        ptr = head;
        while (ptr != null) {
            if (ptr.random != null) {
                Integer index = origPos.get(ptr.random);
                temp.random = newPos.get(index);
            }
            temp = temp.next;
            ptr = ptr.next;

        }
        return newHead;

    }


    public static void main(String[] args) {
        Node head = new Node();
        head.val = 1;
        Node heaDNext = new Node();
        heaDNext.val = 2;
        heaDNext.random = heaDNext;
        head.random = heaDNext;
        head.next = heaDNext;
        Node newHead = copyRandomList(head);

    }

}