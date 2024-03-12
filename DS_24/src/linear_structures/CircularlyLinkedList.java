package linear_structures;

public class CircularlyLinkedList<T> {
    private static class Node<T> {
        /**
         * Identical to the Node in SLL
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
    private Node<T> tail; // we will keep only tail. Head is tail.next
    private int size;
    public CircularlyLinkedList() {
        this.tail = null;
        this.size = 0;
    }
    public int size() {return size;}
    public boolean isEmpty() {
        return size == 0;
    }
    public T head() {
        if(isEmpty()) return null;
        return this.tail.getNext().getValue(); // head is the node after the tail
    }
    public T tail() {
        if(isEmpty()) return null;
        return this.tail.getValue();
    }

    public void rotate() {
        if(!isEmpty()) {
            this.tail = this.tail.getNext(); // the previous head becomes tail now
        }
    }

    public void prepend(T value) {
        if(isEmpty()) {
            this.tail = new Node<>(value, null);
            this.tail.setNext(this.tail); // link to itself since head (i.e. tail.next) and tail are the same
        } else {
            Node<T> newest = new Node<>(value, this.tail.getNext()); // link to the current head
            this.tail.setNext(newest);
        }
        size++;
    }
    public void append(T value) {
        prepend(value);
        rotate();
    }

    public T popFirst() {
        if(isEmpty()) return null;
        T headValue;
        if(size == 1) {
            headValue = this.tail.getValue();
            this.tail = null;
        } else {
            headValue = this.tail.getNext().getValue();
            this.tail.setNext(this.tail.getNext().getNext()); // removes head from the list
        }
        size--;
        return headValue;
    }

    public T pop() {
        if(isEmpty()) return null;
        T headValue;
        if(size == 1) {
            headValue = this.tail.getValue();
            this.tail = null;
        } else {
            Node<T> current = this.tail.getNext();
            while (current.getNext() != this.tail)
                current = current.getNext(); // find the second last node
            headValue = current.getNext().getValue();
            current.setNext(this.tail.getNext());
            this.tail = current;
        }
        size--;
        return headValue;
    }
    public T[] toArray() {
        T[] elements = (T[]) new Object[size()];
        if (isEmpty()) return elements;
        Node<T> current = this.tail.getNext();
        int index = 0;
        while (index < size) {
            elements[index++] = current.getValue();
            current = current.getNext();
        }
        return elements;
    }
}
