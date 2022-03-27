import ADT.LinkedList;

import java.util.ArrayList;

public class SinglyLinkedList<T> extends LinkedList<T> {
	private Node<T> head;
	private Node<T> tail;
	public SinglyLinkedList() {
	}
	public SinglyLinkedList(T... values) {
		for(T value: values)
			append(value);
	}

	public T head() {
		return this.head.getValue();
	}
	public T tail() {
		return this.tail.getValue();
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public void prepend(T value) {
		// add a node in the beginning
		if (isEmpty()) {
			head = new Node<>(value);
			tail =  head;
		} else {
			Node<T> temp = this.head;
			this.head = new Node<>(value);
			this.head.setNext(temp);
		}
		size++;
	}
	public void append(T value) {
		// Add a node in the end
		if (isEmpty()) {
			head = new Node<>(value);
			tail =  head;
		} else {
			Node<T> temp = this.tail;
			this.tail = new Node<>(value);
			temp.setNext(this.tail);
		}
		size++;
	}
	public ArrayList<T> toList() {
		ArrayList<T> list = new ArrayList<>();
		Node<T> dummy = this.head;
		while (dummy != null) {
			list.add(dummy.getValue());
			dummy = dummy.getNext();
		}
		return list;
	}
	public T pop() {
		// Remove a node from the end and return it
		T val;
		if (isEmpty()) {
			return null;
		}
		else if (size == 1) {
			val = this.head.getValue();
			this.head = null;
			this.tail = null;
		} else {
			Node<T> current = head;
			while (current.getNext() != null && current.getNext().getNext() != null) {
				current = current.getNext();
			}
			val = current.getNext().getValue();
			current.setNext(null);
			this.tail = current;
		}
		size--;
		return val;
	}
	public T popFirst() {
		T val;
		if (size == 0) {
			return null;
		}
		else if (size == 1) {
			val = this.head.getValue();
			this.head = null;
			this.tail = null;
		} else {
			val = this.head.getValue();
			this.head = this.head.getNext();
		}
		size--;
		return val;
	}
	public T remove(T target) {
        // Remove Node from the list
        Node<T> current = head;
        Node<T> prev = null;
        while (current != null) {
            T val;
            if (current.getValue() == target) {
                val = current.getValue();
                if (prev == null) {
                    // it's head
                    if (size == 1) {
                        this.head = null;
                        this.tail = null;
                    } else {
                        this.head = this.head.getNext();
                    }
                } else if (current.getNext() == null) {
                    // is tail
                    prev.setNext(null);
                    this.tail = prev;
                }
                else {
                    prev.setNext(current.getNext());
                }
                return val;
            } else {
                prev = current;
                current = current.getNext();
            }
        }
        return null;
    }

	@Override
	public int indexOf(T value) {
		return 0;
	}

	public void reverse() {
		// reverse the linked list in place, do not return anything just mutate it
		this.tail = this.head;
		Node<T> next;
		Node<T> prev = null;
		Node<T> current = this.head;
		while (current != null) {
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		this.head = prev;
	}
}
