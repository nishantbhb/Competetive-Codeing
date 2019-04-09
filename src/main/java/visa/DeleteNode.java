package visa;

public class DeleteNode {
    public static SinglyLinkedListNode removeNodes(SinglyLinkedListNode listHead, int x) {
        // Write your code here
        if (listHead == null)
            return null;

        while (listHead != null && listHead.data > x)
            listHead = listHead.next;

        SinglyLinkedListNode head = listHead;

        SinglyLinkedListNode prev = listHead;

        SinglyLinkedListNode ptr = listHead != null ? listHead.next : null;

        while (prev != null && ptr != null && ptr.next != null) {
            if (ptr.data > x) {
                ptr = ptr.next;
            } else {
                prev.next = ptr;
                ptr = ptr.next;
                prev = prev.next;
            }
        }
        if (prev != null) {
            prev.next = null;//to mark the last node
        }
        return head;

    }

    class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;
    }
}
