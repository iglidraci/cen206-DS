public class AvlNode<T extends Comparable<T>> {
    private int height = 0; // by convention leaves have height 0
    private AvlNode<T> left;
    private AvlNode<T> right;
    private AvlNode<T> parent;
    private T value;

    public AvlNode(T value, AvlNode<T> left, AvlNode<T> right, AvlNode<T> parent) {
        this.value = value;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    public AvlNode(T value) {
        this.value = value;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public AvlNode<T> getLeft() {
        return left;
    }

    public void setLeft(AvlNode<T> left) {
        this.left = left;
    }

    public AvlNode<T> getRight() {
        return right;
    }

    public void setRight(AvlNode<T> right) {
        this.right = right;
    }

    public AvlNode<T> getParent() {
        return parent;
    }

    public void setParent(AvlNode<T> parent) {
        this.parent = parent;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public int getHeight() {
        return height;
    }
}
