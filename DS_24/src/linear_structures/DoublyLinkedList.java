package linear_structures;

public class DoublyLinkedList<T> {
    /*
     * Double Linked List with sentinels as Head and Tail
     * Sentinel nodes are 'dummy' nodes, they do not store any value
     * Head sentinel, points next to the actual head
     * Tail sentinel, points previously to the actual tail of the list
     * For example: Head ⇄ 1 ⇄ 2 ⇄ 3 ⇄ 4 ⇄ Tail
     * In SSL we represent the same nodes as: Head = 1 -> 2 -> 3 -> 4 = Tail
     */


    // nested Node class, with next and prev
    private static class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> prev;
        public Node(T value, Node<T> prev, Node<T> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    } // end of the Node class

    private Node<T> head;
    private Node<T> tail;
    private int size;
    public DoublyLinkedList() {
        this.head = new Node<>(null, null, null); // Head sentinel
        this.tail = new Node<>(null, this.head, null); // Tail sentinel
        this.head.setNext(this.tail); // head is followed by tail
        // Think of it as: Head ⇄ Tail, not as: Head = Tail
    }
    public int size() {return size;}
    public boolean isEmpty() {
        return size == 0;
    }
    public T head() {
        return this.head.getNext().getValue();
    }
    public T tail() {
        return this.tail.getPrev().getValue();
    }

    public void prepend(T value) {
        addBetween(value, this.head, this.head.getNext());
    }

    public void append(T value) {
        addBetween(value, this.tail.getPrev(), this.tail);
    }

    private void addBetween(T value, Node<T> predecessor, Node<T> successor) {
        // adds value to a DLL between the given nodes
        Node<T> newest = new Node<>(value, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    public T popFirst() {
        if(isEmpty()) return null;
        return unlinkNode(this.head.getNext());
    }

    public T pop() {
        if(isEmpty()) return null;
        return unlinkNode(this.tail.getPrev());
    }

    private T unlinkNode(Node<T> node) {
        Node<T> predecessor = node.getPrev();
        Node<T> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getValue();
    }

    public T[] toArray() {
        T[] elements = (T[]) new Object[size()];
        if (isEmpty()) return elements;
        Node<T> current = this.head.getNext();
        int index = 0;
        while (index < size) {
            elements[index++] = current.getValue();
            current = current.getNext();
        }
        return elements;
    }
}
