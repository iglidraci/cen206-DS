package ADT;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public abstract class AbstractTree<T> implements Tree<T> {
    public boolean isInternal(Position<T> position) {
        return this.numberChildren(position) > 0;
    }
    public boolean isLeaf(Position<T> position) {
        return this.numberChildren(position) == 0;
    }
    public boolean isRoot(Position<T> position) {
        return this.root() == position;
    }
    public boolean isEmpty() {
        return this.size() == 0;
    }
    public int depth(Position<T> position) {
        if (isRoot(position)) return 0;
        return 1 + depth(parent(position));
    }
    public int height(Position<T> position) {
        // there's no need to check whether is a leaf or not
        int h = 0;
        for(var c: children(position))
            h = Math.max(h, 1 + height(c));
        return h;
    }
    // height of the tree (root)
    public int height() {
        return this.height(this.root());
    }
    /*
    * traversals
    * */
    public ArrayList<T> preorder() {
        ArrayList<T> nodes = new ArrayList<>(size());
        preorder(root(), nodes);
        return nodes;
    }
    private void preorder(Position<T> p, ArrayList<T> nodes) {
        nodes.add(p.getElement());
        for(Position<T> child: children(p)) {
            preorder(child, nodes);
        }
    }
    public ArrayList<T> postorder() {
        ArrayList<T> nodes = new ArrayList<>(size());
        postorder(root(), nodes);
        return nodes;
    }
    private void postorder(Position<T> p, ArrayList<T> nodes) {
        for(Position<T> child: children(p)) {
            postorder(child, nodes);
        }
        nodes.add(p.getElement());
    }
    public ArrayList<T> breadthFirst() {
        ArrayList<T> nodes = new ArrayList<>(size());
        breadthFirst(root(), nodes);
        return nodes;
    }
    private void breadthFirst(Position<T> p, ArrayList<T> nodes) {
        Queue<Position<T>> queue = new ArrayDeque<>();
        queue.add(p);
        while (!queue.isEmpty()) {
            Position<T> current = queue.remove();
            nodes.add(current.getElement());
            for(Position<T> child : children(current))
                queue.add(child);
        }
    }
}
