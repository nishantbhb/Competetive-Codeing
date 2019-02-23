package com.nishant.algo;


class ListNode {
    ListNode next;
    int val;

    ListNode(int x) {
        val = x;
        next = null;
    }
}


public class OddEvenLinkedList {
    private static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode evenTail = head.next;
        ListNode oddTail = head;
        ListNode evenHead = head.next;
        while (evenTail != null && evenTail.next != null) {
            oddTail.next = evenTail.next;
            oddTail = oddTail.next;

            evenTail.next = oddTail.next;
            evenTail = evenTail.next;
        }
        oddTail.next = evenHead;
        return head;

    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println(oddEvenList(head));


    }

}