public class Node<T extends Comparable<T>> {
    // Node should be comparable
    private T value;
    private Node<T> left;
    private Node<T> right;
    private Node<T> parent;

    public Node(T value, Node<T> left, Node<T> right, Node<T> parent) {
        this.value = value;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }
}
