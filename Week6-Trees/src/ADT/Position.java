package ADT;

public abstract class Position<T> {
    T element;
    public Position(T element) {
        this.element = element;
    }
    public T getElement() {
        return this.element;
    }
    public void setElement(T element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}
