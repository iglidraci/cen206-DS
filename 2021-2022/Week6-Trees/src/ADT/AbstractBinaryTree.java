package ADT;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBinaryTree<T> extends AbstractTree<T> implements BinaryTree<T> {
    @Override
    public Position<T> sibling(Position<T> position) {
        if (isRoot(position)) return null;
        Position<T> parent = parent(position);
        if (leftChild(parent) == position)
            return rightChild(parent);
        else return leftChild(parent);
    }
    @Override
    public int numberChildren(Position<T> position) {
        int count = 0;
        if (leftChild(position) != null) count++;
        if (rightChild(position) != null) count++;
        return count;
    }
    @Override
    public Iterable<Position<T>> children(Position<T> position) {
        // ordered so that the left child is placed before the right child
        List<Position<T>> children = new ArrayList<>();
        if (leftChild(position) != null) children.add(leftChild(position));
        if (rightChild(position) != null) children.add(rightChild(position));
        return children;
    }
}
