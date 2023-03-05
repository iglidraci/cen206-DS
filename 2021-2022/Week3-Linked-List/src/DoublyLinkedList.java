import ADT.LinkedList;

import java.util.ArrayList;
import java.util.Optional;

public class DoublyLinkedList<T> extends LinkedList<T> {
    // head and tail will serve now as sentinels
    // head.next will point to the first element of the linked list
    // tail.prev will point to the last element of the linked list
    private Node<T> head;
    private Node<T> tail;
    public DoublyLinkedList() {
        head = new Node<>();
        tail = new Node<>(null, null, head);
        head.setNext(tail);
    }
    public DoublyLinkedList(T... values) {
        this();
        for(T val: values)
            append(val);
    }
    @Override
    public void prepend(T value) {
        addBetween(value, head, head.getNext());
    }

    private void addBetween(T value, Node<T> predecessor, Node<T> successor) {
        Node<T> newNode = new Node<>(value, successor, predecessor);
        predecessor.setNext(newNode);
        successor.setPrev(newNode);
        size++;
    }

    @Override
    public void append(T value) {
        addBetween(value, tail.getPrev(), tail);
    }

    @Override
    public T pop() {
        if (isEmpty()) return null;
        return removeNode(tail.getPrev());
    }

    private T removeNode(Node<T> node) {
        Node<T> predecessor = node.getPrev();
        Node<T> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getValue();
    }

    @Override
    public T popFirst() {
        if (isEmpty()) return null;
        return removeNode(head.getNext());
    }

    @Override
    public T head() {
        if (isEmpty()) return null;
        return head.getNext().getValue();
    }

    @Override
    public T tail() {
        if (isEmpty()) return null;
        return tail.getPrev().getValue();
    }

    @Override
    public T remove(T value) {
        if (isEmpty())
            return null;
        Node<T> dummyHead = this.head.getNext();
        while (dummyHead.getValue() != value) {
            dummyHead = dummyHead.getNext();
        }
        return removeNode(dummyHead);
    }

    @Override
    public int indexOf(T value) {
        return 0;
    }
    @Override
    public void reverse() {

    }

    @Override
    public ArrayList<T> toList() {
        ArrayList<T> values = new ArrayList<>();
        if (!isEmpty()) {
            Node<T> dummy = head.getNext();
            do {
                values.add(dummy.getValue());
                dummy = dummy.getNext();
            } while (dummy != tail);
        }
        return values;
    }
    @Override
    public String toString() {
        Optional<String> result = toList().stream().map(Object::toString)
                .reduce((x, y) -> x + " <-> " + y);
        return result.map(s -> "Head <-> " + s + " <-> Tail").orElse("[]");
    }
}
