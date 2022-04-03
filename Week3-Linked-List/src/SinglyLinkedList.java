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
		if (isEmpty()) return -1;
		Node<T> current = this.head;
		int index = 0;
		while(current != null) {
			if (current.getValue() == value)
				return index;
			current = current.getNext();
			index++;
		}
		// we reached the end and the value wasn't found
		return -1;
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
	public void rotate(int k) {
		/*
		* rotate by k nodes to the right
		* Example: 1 -> 2 -> 3 -> 4 -> 5 -> null
		* k = 2
		* Result: 4 -> 5 -> 1 -> 2 -> 3 -> null
		* */
		if (isEmpty()) return;
		k = k%size;
		if (k == 0) return;
		int moveFromHead = size - k - 1;
		Node<T> newTail = this.head;
		while (moveFromHead != 0) {
			newTail = newTail.getNext();
			moveFromHead--;
		}
		Node<T> subList = newTail.getNext();
		newTail.setNext(null);
		this.tail.setNext(this.head);
		this.tail = newTail;
		this.head = subList;
	}
	public SinglyLinkedList<T>[] split(int k) {
		/*
		* split the linked list with k consecutive linked list parts
		* the length of each part should be as equal as possible
		* return an array of linked lists
		* */
		if (isEmpty()) return null;
		int items = size/k;	// each part will have at least size/k items
		int extraItems = size % k; // the first size%k parts will have one item extra
		SinglyLinkedList<T>[] parts = new SinglyLinkedList[k];
		Node<T> current = this.head;
		for (int i = 0; i < k; i++) {
			SinglyLinkedList<T> part = new SinglyLinkedList<>();
			for (int j = 0; j < items; j++) {
				part.append(current.getValue());
				current = current.getNext();
			}
			if (i + 1 <= extraItems) {
				part.append(current.getValue());
				current = current.getNext();
			}
			parts[i] = part;
		}
		return parts;
	}
}
