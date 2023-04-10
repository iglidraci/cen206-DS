import java.util.ArrayList;

public abstract class AbstractBinaryTree<T> extends AbstractTree<T> implements BinaryTree<T> {
    /**Returns the Position of p's sibling (or null if no sibling exists)*/
    @Override
    public Position<T> sibling(Position<T> p) {
        Position<T> parent = parent(p);
        if(parent == null) return null;
        if(p == left(parent)) return right(parent);
        else return left(parent);
    }

    /**Returns the number of children of Position p*/
    @Override
    public int numChildren(Position<T> p) {
        int count = 0;
        if(left(p) != null) count++;
        if(right(p) != null) count++;
        return count;
    }

    /**Returns an iterable collection of the Positions representing p's children. */
    @Override
    public Iterable<Position<T>> children(Position<T> p) throws IllegalArgumentException {
        ArrayList<Position<T>> snapshot = new ArrayList<>(2);
        if(left(p) != null) snapshot.add(left(p));
        if(right(p) != null) snapshot.add(right(p));
        return snapshot;
    }

    /**Inorder traversal of the tree*/
    public Iterable<Position<T>> inorder() {
        ArrayList<Position<T>> elements = new ArrayList<>();
        inorderTraversal(root(), elements);
        return elements;
    }

    private void inorderTraversal(Position<T> p, ArrayList<Position<T>> elements) {
        if(left(p) != null)
            inorderTraversal(left(p), elements);
        elements.add(p);
        if(right(p) != null)
            inorderTraversal(right(p), elements);
    }
}
