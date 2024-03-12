package linear_structures;

public interface Deq<T> { // Double-ended queue
    int size();
    boolean isEmpty();

    /**
     * @return the first element in the deque, but does not remove
     */
    T first();

    /**
     * @return the last element in the deque, but does not remove
     */
    T last();

    /**
     *
     * @param element to be inserted on the front of the deque
     */
    void addFirst(T element);

    /**
     *
     * @param element to be inserted on the back of the deque
     */
    void addLast(T element);

    T removeFirst();
    T removeLast();
}
