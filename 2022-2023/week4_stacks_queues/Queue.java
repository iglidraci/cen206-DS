public interface Queue<T> {
    int size();
    boolean isEmpty();
    void enqueue(T element);
    T dequeue();
    T peek();
}
