public interface Stack<T> {
    /**
     * The number of elements in the stack
     * @return number of elements
     */
    int size();

    /**
     * @return true if empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Add an element on top of the stack
     * @param element to be pushed on top of the stack
     */
    void push(T element);

    /**
     * Return the top element, do not remove it
     * @return element on top of the stack
     */
    T peek();

    /**
     * Removes and returns the element on top of the stack
     * @return removed element if any, null otherwise
     */
    T pop();

}
