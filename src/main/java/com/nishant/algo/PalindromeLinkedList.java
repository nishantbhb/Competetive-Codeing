package com.nishant.algo;


/*class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}*/


public class PalindromeLinkedList {
    private static boolean isPalindrome(ListNode head) {
        if (head == null)
            return false;
        if (head.next == null)
            return true;
        ListNode slow = head.next;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {
            ListNode temp = slow.next;
            slow.next = head;
            head = slow;
            slow = temp;
            fast = fast.next.next;
        }
        if (fast != null)
            slow = slow.next;//odd number of nodes
        fast = slow;
        slow = head;

        while (fast != null) {
            if (slow.val != fast.val)
                return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;

    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);
        /*head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(0);
        head.next.next.next.next.next = new ListNode(1);*/
        System.out.println(isPalindrome(head));


    }

}