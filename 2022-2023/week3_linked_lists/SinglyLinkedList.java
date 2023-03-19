public class SinglyLinkedList<T> {
    private static class Node<T> {
        /**
         * Generic Nested Node class to represent each node in the linked list
         * value will hold a reference to the element stored in this node
         * next will hold a pointer to the subsequent node in the list
         */
        private T value;
        private Node<T> next;
        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
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
    public SinglyLinkedList() {
        // all three are by default this way but just to be more explicit
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    public int size() {
        return this.size;
    }
    public boolean isEmpty() {return this.size == 0;}
    public T head() {
        // return the first element in the list
        if(isEmpty()) return null;
        return head.getValue();
    }
    public T tail() {
        // return the last element in the list
        if (isEmpty()) return null;
        return tail.getValue();
    }

    public void prepend(T value) {
        // adds element to the head of the list
        this.head = new Node<>(value, this.head);
        if (size == 0)
            this.tail = this.head; // case when this is the first element appended to the list, tail is head
        size++;
    }

    public void append(T value) {
        // adds element to the tail of the list
        Node<T> newTail = new Node<>(value, null);
        if (isEmpty()) {
            this.head = newTail;
        } else {
            this.tail.setNext(newTail);
        }
        this.tail = newTail;
        size++;
    }

    public T popFirst() {
        // remove the first element in the list and return it
        if (isEmpty()) return null;
        T value = this.head.getValue();
        this.head = this.head.getNext();
        size--;
        if (isEmpty())
            this.tail = null;
        return value;
    }

    public T pop() {
        // remove the last element from the list and return it
        if (isEmpty()) return null; // no element to remove
        T value;
        if (size() == 1) {
            value = this.head.getValue();
            this.head = this.tail = null;
        } else {
            Node<T> current = head;
            while (current.getNext().getNext() != null)
                current = current.getNext(); // find the second last node
            value = current.getNext().getValue();
            current.setNext(null);
            this.tail = current;
        }
        size--;
        return value;
    }

    public T[] toArray() {
        T[] elements = (T[]) new Object[size()];
        Node<T> current = this.head;
        int index = 0;
        while (current != null) {
            elements[index++] = current.getValue();
            current = current.getNext();
        }
        return elements;
    }
}
