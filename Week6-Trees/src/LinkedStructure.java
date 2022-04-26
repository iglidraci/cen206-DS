import ADT.Position;

public class LinkedStructure<T> extends Position<T> {
    private LinkedStructure<T> parent;
    private LinkedStructure<T> left;
    private LinkedStructure<T> right;

    public LinkedStructure(T element) {
        super(element);
    }

    public LinkedStructure(T element, LinkedStructure<T> parent, LinkedStructure<T> left, LinkedStructure<T> right) {
        super(element);
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    public LinkedStructure<T> getParent() {
        return parent;
    }

    public void setParent(LinkedStructure<T> parent) {
        this.parent = parent;
    }

    public LinkedStructure<T> getLeft() {
        return left;
    }

    public void setLeft(LinkedStructure<T> left) {
        this.left = left;
    }

    public LinkedStructure<T> getRight() {
        return right;
    }

    public void setRight(LinkedStructure<T> right) {
        this.right = right;
    }
}
