import java.util.Stack;

public class StackQueue<T> implements Queue<T> {
    private final Stack<T> primaryStack = new Stack<>();
    private final Stack<T> auxiliaryStack = new Stack<>();
    @Override
    public void enqueue(T value) {
        primaryStack.push(value);
    }

    @Override
    public T dequeue() {
        while (primaryStack.size() > 1) {
            auxiliaryStack.push(primaryStack.pop());
        }
        T value = primaryStack.pop();
        while (!auxiliaryStack.isEmpty())
            primaryStack.push(auxiliaryStack.pop());
        return value;
    }

    @Override
    public T peek() {
        while (primaryStack.size() > 1) {
            auxiliaryStack.push(primaryStack.pop());
        }
        T value = primaryStack.peek();
        while (!auxiliaryStack.isEmpty())
            primaryStack.push(auxiliaryStack.pop());
        return value;
    }

    @Override
    public boolean isEmpty() {
        return primaryStack.isEmpty();
    }

    @Override
    public int size() {
        return primaryStack.size();
    }
}
