public class ArrayQueue<T> implements Queue<T> {
    private T[] data;
    private int size;
    private int front;
    private static final int DEFAULT_CAPACITY = 1000;
    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }
    public ArrayQueue(int capacity) {
        this.data = (T[]) new Object[capacity];
        this.size = 0;
        this.front = 0;
    }
    @Override
    public void enqueue(T value) {
        if (size == data.length) throw new IllegalArgumentException("Queue is full");
        int backOfQueue = (front + size) % data.length;
        this.data[backOfQueue] = value;
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) return null;
        T value = this.data[front];
        front = (front + 1) % data.length;
        size--;
        return value;
    }

    @Override
    public T peek() {
        if (isEmpty()) return null;
        return this.data[front];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
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
