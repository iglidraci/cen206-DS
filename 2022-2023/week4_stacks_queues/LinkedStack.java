import java.util.LinkedList;

public class LinkedStack<T> implements Stack<T> {
    private final LinkedList<T> list = new LinkedList<>();
    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(T element) {
        this.list.addFirst(element);
    }

    @Override
    public T peek() {
        return list.peek();
    }

    @Override
    public T pop() {
        return list.poll();
    }
}
