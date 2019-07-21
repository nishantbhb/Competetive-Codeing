package com.nishant.algo;

public class LinkedListSum {

    private static Node addList(Node p1, Node p2) {
        if (p1 == null)
            return p2;
        if (p2 == null)
            return p1;

        int ctr1 = 0;
        int ctr2 = 0;

        Node ptr1 = p1;
        Node ptr2 = p2;

        //calculate length of each list
        while (ptr1 != null) {
            ctr1++;
            ptr1 = ptr1.next;
        }

        while (ptr2 != null) {
            ctr2++;
            ptr2 = ptr2.next;
        }

        Carry carry = new Carry();

        //add padding to the list with smaller length
        if (ctr1 > ctr2) {
            p2 = addZeroes(p2, ctr1 - ctr2);
        } else {
            p1 = addZeroes(p1, ctr2 - ctr1);
        }

        Node sum = addListUtil(p1, p2, carry);
        //in case of carry add a new node in the beginning
        if (carry.carry > 0) {
            Node temp = new Node(carry.carry);
            temp.next = sum;
            sum = temp;
        }
        return sum;


    }

    private static Node addZeroes(Node p, int ctr) {
        while (ctr > 0) {
            Node temp = new Node(0);
            temp.next = p;
            p = temp;
            ctr--;
        }

        return p;
    }

    static Node addListUtil(Node p1, Node p2, Carry carry) {

        if (p1 == null && p2 == null) {
            return null;
        }

        Node sum = new Node(carry.carry);

        //recursively make call to the next pointers
        sum.next = addListUtil(p1.next, p2.next, carry);


        int s = p1.val + p2.val + carry.carry;
        carry.carry = s / 10;

        sum.val = s % 10;

        return sum;
    }

    public static void main(String[] args) {
        Node a = new Node(9);
        a.next = new Node(2);
        a.next.next = new Node(3);

        Node b = new Node(1);
        b.next = new Node(2);
        b.next.next = new Node(3);
        b.next.next.next = new Node(4);

        Node sum = addList(a, b);
        while (sum != null) {
            System.out.println(sum.val);
            sum = sum.next;
        }

    }

    static class Node {
        int val;
        Node next;

        Node(int x) {
            this.val = x;
        }
    }

    static class Carry {
        int carry = 0;
    }
}
