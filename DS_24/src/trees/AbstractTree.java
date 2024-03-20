package trees;

import java.util.ArrayList;

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

    private int heightBad() {
        int h = 0;
        for(Position<T> p : positions()){
            if (isExternal(p))
                h = Math.max(h, depth(p));
        }
        return h;
    }

    @Override
    public int height(Position<T> p) {
        int h = 0;
        for(Position<T> c : children(p))
            h = Math.max(h, 1+ height(c));
        return h;
    }

    // Traversing algorithms
    protected Iterable<Position<T>> preorder() {
        ArrayList<Position<T>> elements = new ArrayList<>();
        if(!isEmpty()) preorderTraversal(root(), elements);
        return elements;
    }
    private void preorderTraversal(Position<T> p, ArrayList<Position<T>> elements) {
        elements.add(p);
        for(Position<T> child : children(p))
            preorderTraversal(child, elements);
    }
}
