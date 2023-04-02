import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public abstract class AbstractTree<T> implements Tree<T> {
    @Override
    public boolean isInternal(Position<T> p) {
        return numChildren(p) > 0;
    }

    @Override
    public boolean isExternal(Position<T> p) {
        return numChildren(p) == 0;
    }

    @Override
    public boolean isRoot(Position<T> p) {
        return p == root();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
    @Override
    public int depth(Position<T> p) {
        if(isRoot(p)) return 0;
        return 1 + depth(parent(p));
    }

    @Override
    public int height(Position<T> p) {
        int h = 0;
        for(Position<T> c : children(p))
            h = Math.max(h, 1+ height(c));
        return h;
    }

    // Traversing algorithms
    public Iterable<Position<T>> preorder() {
        ArrayList<Position<T>> elements = new ArrayList<>();
        if(!isEmpty()) preorderTraversal(root(), elements);
        return elements;
    }

    public Iterable<Position<T>> postorder() {
        ArrayList<Position<T>> elements = new ArrayList<>();
        if(!isEmpty()) postorderTraversal(root(), elements);
        return elements;
    }
    private void preorderTraversal(Position<T> p, ArrayList<Position<T>> elements) {
        elements.add(p);
        for(Position<T> child : children(p))
            preorderTraversal(child, elements);
    }
    private void postorderTraversal(Position<T> p, ArrayList<Position<T>> elements) {
        for(Position<T> child : children(p))
            postorderTraversal(child, elements);
        elements.add(p);
    }
    public Iterable<Position<T>> breadthFirst() {
        ArrayList<Position<T>> elements = new ArrayList<>();
        if (!isEmpty()) {
            Queue<Position<T>> queue = new ArrayDeque<>();
            queue.add(root());
            while (!queue.isEmpty()) {
                Position<T> p = queue.remove();
                elements.add(p);
                for (Position<T> child : children(p))
                    queue.add(child);
            }
        }
        return elements;
    }
    private void printPreorderIndent(Position<T> p, int d) {
        System.out.println(" ".repeat(2*d) + p.getElement());
        for(Position<T> child : children(p))
            printPreorderIndent(child, d + 1);
    }
    public void printPreorderIndent() {
        printPreorderIndent(root(), 1);
    }
}
