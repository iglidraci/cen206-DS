public class ArrayDeque<T> implements Deque<T> {
    private final T[] data;
    private int front;
    private int size;
    public ArrayDeque() {
        this(1000);
    }
    public ArrayDeque(int capacity) {
        data = (T[]) new Object[capacity];
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T first() {
        if(isEmpty()) return null;
        return data[front];
    }

    @Override
    public T last() {
        if(isEmpty()) return null;
        int lastIndex = (front + size - 1) % this.data.length;
        return data[lastIndex];
    }

    @Override
    public void addFirst(T element) {
        if(size == data.length) throw new IllegalStateException("Deque is full");
        front = (front - 1 + data.length) % data.length;
        data[front] = element;
        size++;
    }

    @Override
    public void addLast(T element) {
        if(size == data.length) throw new IllegalStateException("Deque is full");
        int end = (front + size) % data.length;
        data[end] = element;
        size++;
    }

    @Override
    public T removeFirst() {
        if(isEmpty()) return null;
        T element = data[front];
        data[front] = null; // help garbage collector
        front = (front + 1) % data.length;
        size--;
        return element;
    }

    @Override
    public T removeLast() {
        if(isEmpty()) return null;
        int end = (front + size - 1) % data.length;
        T element = data[end];
        data[end] = null;
        size--;
        return element;
    }
}
