public class ArrayQueue<T> implements Queue<T> {
    private final T[] data;
    private int size = 0;
    private int front = 0;
    public ArrayQueue(){
        this(1000);
    }
    public ArrayQueue(int capacity) {
        this.data = (T[]) new Object[capacity];
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
    public void enqueue(T element) {
        if(size == data.length) throw new IllegalStateException("Queue is full");
        int end = (front + size) % data.length;
        data[end] = element;
        size++;
    }

    @Override
    public T dequeue() {
        if(isEmpty()) return null;
        T element = data[front];
        data[front] = null; // help garbage collector
        front = (front + 1) % data.length;
        size--;
        return element;
    }

    @Override
    public T peek() {
        if(isEmpty()) return null;
        return data[front];
    }
}
