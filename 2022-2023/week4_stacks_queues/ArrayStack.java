import java.util.ArrayList;

public class ArrayStack<T> implements Stack<T> {

    private final T[] elements; // array used to store the elements of the stack
    private int top = -1; // index of the top element of the stack
    public ArrayStack(){
        this(1000); // default capacity
    }
    public ArrayStack(int capacity) {
        this.elements = (T[]) new Object[capacity];
    }
    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void push(T element) {
        if(size() == this.elements.length)
            throw new IllegalStateException("Stack is full");
        this.elements[++top] = element;
    }

    @Override
    public T peek() {
        if(isEmpty()) return null;
        return this.elements[top];
    }

    @Override
    public T pop() {
        if(isEmpty()) return null;
        T topElement = this.elements[top];
        this.elements[top--] = null; // help garbage collector
        return topElement;
    }
}
