import java.util.*;

public class QueueStack<T> implements Stack<T> {
    private Queue<T> q1 = new ArrayDeque<>();
    private Queue<T> q2 = new ArrayDeque<>();
    @Override
    public T pop() {
        if (isEmpty()) return null;
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }
        // here is the element we want to pop from the stack
        T val = q1.remove();
        // swap q1 with q1, don't copy elements around
        Queue<T> temp = q1;
        q1 = q2;
        q2 = temp;
        return val;
    }

    @Override
    public void push(T value) {
        this.q1.add(value);
    }

    @Override
    public boolean isEmpty() {
        return this.q1.isEmpty();
    }

    @Override
    public int size() {
        return this.q1.size();
    }

    @Override
    public T peek() {
        if (isEmpty()) return null;
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }
        // here is the element we want to pop from the stack
        T val = q1.remove();
        while (!q2.isEmpty()) {
            q1.add(q2.remove());
        }
        q1.add(val);
        return val;
    }
    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder res = new StringBuilder("QueueStack [");
        var iterator = this.q1.iterator();
        ArrayList<T> list = new ArrayList<>();
        while (iterator.hasNext())
            list.add(iterator.next());
        Collections.reverse(list);
        for(T val: list)
            res.append(val.toString()).append(" ");
        return res.append("]").toString();
    }
}
