public class ArrayDeque<T> implements Deque<T> {
    private final T[] data;
    private int size;
    private int front;
    private static final int DEFAULT_CAPACITY = 1000;
    public ArrayDeque(int capacity) {
        this.data = (T[]) new Object[capacity];
        this.size = 0;
        this.front = 0;
    }
    public ArrayDeque() {
        this(DEFAULT_CAPACITY);
    }
    @Override
    public void addFirst(T value) {
        checkIfFull();
        int frontOfQueue = (front - 1 + data.length) % data.length;
        this.data[frontOfQueue] = value;
        this.size++;
        this.front = frontOfQueue;
    }

    private void checkIfFull() {
        if (size == this.data.length) throw new IllegalArgumentException("Queue is full");
    }

    @Override
    public void addLast(T value) {
        checkIfFull();
        int backOfQueue = (front + size) % data.length;
        this.data[backOfQueue] = value;
        size++;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) return null;
        T value = this.data[front];
        front = (front + 1) % data.length;
        size--;
        return value;
    }

    @Override
    public T removeLast() {
        if(isEmpty()) return null;
        int lastIndex = (front + size - 1) % this.data.length;
        size--;
        return this.data[lastIndex];
    }

    @Override
    public T first() {
        if (isEmpty()) return null;
        return this.data[front];
    }

    @Override
    public T last() {
        if (isEmpty()) return null;
        int lastIndex = (front + size - 1) % this.data.length;
        return this.data[lastIndex];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        int i = 0;
        while (i < size) {
            result.append(this.data[(front + i++) % data.length]).append(",");
        }
        result.append("]");
        return result.toString();
    }
}
