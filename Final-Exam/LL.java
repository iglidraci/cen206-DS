public class LL {
    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5)))));
        SplitList splitList = splitEqual(head);
        printLinkedList(splitList.head1);
        printLinkedList(splitList.head2);
    }
    static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
    static SplitList splitEqual(Node head) {
        /*
         * the idea is simple
         * we keep a slow and a fast pointer
         * slow pointer makes one step at a time while the fast pointer makes two steps at the time
         * when fast reaches the end, slow is in the middle
         * return both heads
         * this way, we make one single loop and we know we have reached the middle of the list
         */
        SplitList splitList = new SplitList();
        Node slow = head;
        Node fast = head;
        Node prev = null;
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        splitList.head1 = head;
        splitList.head2 = prev.next; // prev could be null, but let's suppose it's not for simplicity
        prev.next = null; // break the two lists from each other
        return splitList;
    }
}

class Node {
    int val;
    Node next;
    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
    public Node(int val) {
        this(val, null);
    }
}

class SplitList {
    Node head1; // the head of the first part
    Node head2; // the head of the second part
}
