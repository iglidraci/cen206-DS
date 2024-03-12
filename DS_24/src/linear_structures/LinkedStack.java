package linear_structures;

public class LinkedStack<T> implements Stack<T> {
    private final SinglyLinkedList<T> list = new SinglyLinkedList<>();
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
        this.list.prepend(element);
    }

    @Override
    public T peek() {
        return list.head();
    }

    @Override
    public T pop() {
        return list.popFirst();
    }
}