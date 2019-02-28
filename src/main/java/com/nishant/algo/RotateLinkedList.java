package com.nishant.algo;


public class RotateLinkedList {
    public void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode newHead = rotateRight(head, 2);

    }

    static ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null)
            return head;
        int ctr = 1;
        ListNode last = head;
        while (last.next != null) {
            last = last.next;
            ctr++;
        }
        k %= ctr;
        k = ctr - k; //for right rotation
        while (k > 0) {
            last.next = head;
            head = head.next;
            last = last.next;
            last.next = null;
            k--;
        }
        return head;

    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}