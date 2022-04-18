import java.util.LinkedList;

public class LinkedQueue<T> implements Queue<T> {
    private final LinkedList<T> data = new LinkedList<>();
    @Override
    public void enqueue(T value) {
        this.data.addLast(value);
    }

    @Override
    public T dequeue() {
        if (isEmpty()) return null;
        return data.removeFirst();
    }

    @Override
    public T peek() {
        if (isEmpty()) return null;
        return data.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public int size() {
        return data.size();
    }
    @Override
    public String toString() {
        return data.toString();
    }
}
