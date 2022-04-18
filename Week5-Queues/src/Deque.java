public interface Deque<T> {
    void addFirst(T value);
    void addLast(T value);
    T removeFirst();
    T removeLast();
    T first();
    T last();
    int size();
    boolean isEmpty();
}
