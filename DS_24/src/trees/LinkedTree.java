package trees;

import java.util.*;

public class LinkedTree<T> extends AbstractTree<T> {
    // nested TreeNode class
    protected static class TreeNode<T> implements Position<T> {
        private T element;
        private TreeNode<T> parent;
        private final ArrayList<Position<T>> children = new ArrayList<>();
        public TreeNode(T t, TreeNode<T> above) {
            element = t;
            parent = above;
        }
        @Override
        public T getElement() {
            return element;
        }
        public TreeNode<T> getParent() {
            return this.parent;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public void setParent(TreeNode<T> parent) {
            this.parent = parent;
        }

        public ArrayList<Position<T>> getChildren() {
            return children;
        }
        @Override
        public String toString() {
            return element.toString();
        }
    } // end of the nested class

    protected TreeNode<T> root = null; // root of the tree
    private int size = 0; // number of nodes in the tree
    public LinkedTree() {

    }

    /**Validate the position of a tree and returns it as a TreeNode*/
    protected TreeNode<T> validate(Position<T> p) throws IllegalArgumentException {
        if (!(p instanceof TreeNode<T> node)) throw new IllegalArgumentException("Not valid position type");
        if(node.getParent() == node) // convention for defunct node
            throw new IllegalArgumentException("p is no longer in the tree");
        return node;
    }
    @Override
    public Position<T> root() {
        return root;
    }

    @Override
    public Position<T> parent(Position<T> p) throws IllegalArgumentException {
        TreeNode<T> node = validate(p);
        return node.getParent();
    }

    @Override
    public Iterable<Position<T>> children(Position<T> p) throws IllegalArgumentException {
        TreeNode<T> node = validate(p);
        return node.getChildren();
    }

    @Override
    public int numChildren(Position<T> p) throws IllegalArgumentException {
        TreeNode<T> node = validate(p);
        return node.getChildren().size();
    }

    @Override
    public int size() {
        return size;
    }

    // update methods supported by this class
    /**Places element t at the root of an empty tree and returns its new Position.*/
    public Position<T> addRoot(T t) throws IllegalArgumentException {
        if(!isEmpty()) throw new IllegalArgumentException("Tree is not empty");
        root = new TreeNode<>(t, null);
        size = 1;
        return root;
    }
    /**Creates a new child of Position p storing element t; returns its Position*/
    public Position<T> addChild(Position<T> p, T t) {
        TreeNode<T> parent = validate(p);
        TreeNode<T> child = new TreeNode<>(t, parent);
        parent.getChildren().add(child);
        size++;
        return child;
    }
    /**Replaces the element at Position p with t and returns the replaced element*/
    public T set(Position<T> p, T t) throws IllegalArgumentException {
        TreeNode<T> node = validate(p);
        T temp = node.getElement();
        node.setElement(t);
        return temp;
    }

    public T remove(Position<T> p) throws IllegalArgumentException {
        TreeNode<T> node = validate(p);
        if(numChildren(p) > 1)
            throw new IllegalArgumentException("p must have 0 or 1 child");
        TreeNode<T> child = (node.children.size() == 0 ? null : (TreeNode<T>) node.children.get(0));
        if(child != null)
            child.setParent(node.getParent());
        if(node == root)
            root = child;
        else {
            TreeNode<T> parent = node.getParent();
            int i = parent.getChildren().indexOf(node);
            parent.children.set(i, child);
        }
        size--;
        T temp = node.getElement();
        node.setElement(null);
        node.setParent(node);  // our convention for defunct node
        return temp;
    }

    @Override
    public Iterable<Position<T>> positions() {
        return preorder();
    }
}
