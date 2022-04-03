import ADT.LinkedList;

import java.util.ArrayList;

/*
* we will keep only a tail pointer
* head will be determined by tail.next
* */

public class CircularlyLinkList<T> extends LinkedList<T> {
    private Node<T> tail;
    private Node<T> iterator;
    public CircularlyLinkList(T... values) {
        for(T value: values)
            this.append(value);
    }
    public CircularlyLinkList(){

    }
    @Override
    public void prepend(T value) {
        if (isEmpty()) {
            tail = new Node<>(value);
            tail.setNext(tail);
        } else {
            Node<T> newNode = new Node<>(value, tail.getNext());
            tail.setNext(newNode);
        }
        size++;
    }

    @Override
    public void append(T value) {
        prepend(value);
        tail = tail.getNext();
    }

    @Override
    public T pop() {
        return null;
    }

    @Override
    public T popFirst() {
        if (isEmpty()) return null;
        Node<T> head = tail.getNext();
        if (size == 1) tail = null;
        else tail.setNext(head.getNext());
        size--;
        return head.getValue();
    }

    @Override
    public T head() {
        if (isEmpty()) return null;
        return tail.getNext().getValue();
    }

    @Override
    public T tail() {
        if (isEmpty()) return null;
        return tail.getValue();
    }

    @Override
    public T remove(T value) {
        return null;
    }

    @Override
    public int indexOf(T value) {
        return 0;
    }

    @Override
    public void reverse() {

    }

    public void rotate() {
        if(!isEmpty())
            tail = tail.getNext();
    }

    @Override
    public ArrayList<T> toList() {
        ArrayList<T> values = new ArrayList<>();
        if (!isEmpty()) {
            Node<T> dummyHead = tail.getNext();
            do {
                values.add(dummyHead.getValue());
                dummyHead = dummyHead.getNext();
            } while (dummyHead != tail.getNext());
        }
        return values;
    }
}
