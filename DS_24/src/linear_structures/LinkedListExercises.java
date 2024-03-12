package linear_structures;

public class LinkedListExercises {
    /**
     * Definition for singly-linked list.
     */
     static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public static void main(String[] args) {
         ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
         printList(head);
         ListNode newHead = rotateRight(head, 7);
         printList(newHead);
    }

    static ListNode reverseList(ListNode head) {
        /*
         * Given the head of a singly linked list, in place reverse the list, and return the head of reversed list.
         *
         * Input: head = [1,2,3,4,5]
         * Output: [5,4,3,2,1]
         */
        ListNode current = null, next = head, prev = null;
        while(next != null) {
            current = next;
            next = next.next;
            current.next = prev;
            prev = current;
        }
        return current;
    }

    static ListNode rotateRight(ListNode head, int k) {
         /*
         Given the head of a linked list, rotate the list to the right by k places.

         Input: [1,2,3,4,5], k = 2
         Output: [4,5,1,2,3]
         --------
         Input: head = [0,1,2], k = 4
         Output: [2,0,1]
          */
        if(head == null || head.next == null) return head;
        // find the tail and also count the number of nodes
        int count = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            count++;
        }
        k = k % count;
        if (k==0) return head;
        ListNode newTail = head;
        for(int i =0; i < count - k - 1; i++)
            newTail = newTail.next;
        ListNode newHead = newTail.next;
        newTail.next = null;
        tail.next = head;
        return newHead;
    }

    static void printList(ListNode head) {
         while (head != null) {
             System.out.print(head.val + ", ");
             head = head.next;
         }
        System.out.println();
    }

    /*
     * Explain how to implement doubly linked list using only one pointer value x.np per node instead of the usual two
     * (next and prev). Assume that all pointer values can be interpreted as k-bit integers.
     * Think of how to implement searching on this list.
     * Don't try to solve this in Java, just think of it theoretically.
     */
}
