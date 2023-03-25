import java.util.LinkedList;

public class LinkedQueue<T> implements Queue<T> {
    private final LinkedList<T> list = new LinkedList<>();
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
        list.addLast(element);
    }

    @Override
    public T dequeue() {
        return list.poll(); // Retrieves and removes the head (first element) of this list, null if empty
    }

    @Override
    public T peek() {
        return list.peek(); // Returns the head of this list, or null if this list is empty
    }
}
