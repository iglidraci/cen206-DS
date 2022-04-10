public class ArrayStack<T> implements Stack<T> {
    private final T[] array;
    private int index;
    private static final int DEFAULT_CAPACITY = 100;

    public ArrayStack(int capacity) {
        this.array = (T[]) new Object[capacity];
        this.index = -1;
    }
    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public T pop() {
        if (isEmpty()) return null;
        return array[index--];
    }

    @Override
    public void push(T value) {
        if (size() == this.array.length) throw new IllegalStateException("Stack is full");
        this.array[++index] = value;
    }

    @Override
    public boolean isEmpty() {
        return index == -1;
    }

    @Override
    public int size() {
        return index + 1;
    }

    @Override
    public T peek() {
        if (isEmpty()) return null;
        return this.array[index];
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder res = new StringBuilder("ArrayStack\n[");
        for (int i = index; i >= 0; i--) {
            if (i==index)
                res.append(this.array[index].toString()).append("\n");
            else if (i == 0)
                res.append(" ").append(this.array[0].toString()).append("]");
            else res.append(" ").append(this.array[index].toString()).append("\n");
        }
        return res.toString();
    }
}
