package linear_structures;

public class LinkedQueue<T> implements Queue<T> {
    private final SinglyLinkedList<T> list = new SinglyLinkedList<>();
    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void enqueue(T element) {
        list.append(element);
    }

    @Override
    public T dequeue() {
        return list.popFirst(); // Retrieves and removes the head (first element) of this list, null if empty
    }

    @Override
    public T peek() {
        return list.head(); // Returns the head of this list, or null if this list is empty
    }
}
