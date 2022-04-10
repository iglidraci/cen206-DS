import java.util.LinkedList;

public class LinkedStack<T> implements Stack<T> {
    private final LinkedList<T> linkedList = new LinkedList<>();

    @Override
    public T pop() {
        // retrieves and removes the head (first element) of this list
        return linkedList.poll();
    }

    @Override
    public void push(T value) {
        this.linkedList.addFirst(value);
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public int size() {
        return linkedList.size();
    }

    @Override
    public T peek() {
        return this.linkedList.getFirst();
    }
    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder res = new StringBuilder("LinkedStack\n[");
        var iterator = this.linkedList.iterator();
        res.append(iterator.next());
        while (iterator.hasNext()) {
            res.append("\n").append(" ").append(iterator.next());
        }
        res.append("]");
        return res.toString();
    }
}
