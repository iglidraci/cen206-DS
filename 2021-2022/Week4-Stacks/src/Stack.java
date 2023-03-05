public interface Stack<T> {
    T pop();
    void push(T value);
    boolean isEmpty();
    int size();
    T peek();
}
