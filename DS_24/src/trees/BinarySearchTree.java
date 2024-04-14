package trees;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> extends AbstractTree<T> {
    // nested BinaryTreeNode class
    protected static class BinaryTreeNode<T> implements Position<T> {
        private T element;
        private BinaryTreeNode<T> parent;
        private BinaryTreeNode<T> left;
        private BinaryTreeNode<T> right;
        public BinaryTreeNode(T t, BinaryTreeNode<T> p, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild) {
            element = t;
            parent = p;
            left = leftChild;
            right = rightChild;
        }
        @Override
        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public BinaryTreeNode<T> getParent() {
            return parent;
        }

        public void setParent(BinaryTreeNode<T> parent) {
            this.parent = parent;
        }

        public BinaryTreeNode<T> getLeft() {
            return left;
        }

        public void setLeft(BinaryTreeNode<T> left) {
            this.left = left;
        }

        public BinaryTreeNode<T> getRight() {
            return right;
        }

        public void setRight(BinaryTreeNode<T> right) {
            this.right = right;
        }
        @Override
        public String toString() {
            return element.toString();
        }
    } // end of nested TreeNode class

    protected BinaryTreeNode<T> root = null;
    private int size = 0;
    /**Validate the position of a tree and returns it as a TreeNode*/
    protected BinaryTreeNode<T> validate(Position<T> p) throws IllegalArgumentException {
        if (!(p instanceof BinaryTreeNode<T> node)) throw new IllegalArgumentException("Not valid position type");
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
        BinaryTreeNode<T> node = validate(p);
        return node.getParent();
    }

    public Position<T> leftChild(Position<T> p) throws IllegalArgumentException {
        BinaryTreeNode<T> node = validate(p);
        return node.getLeft();
    }

    public Position<T> rightChild(Position<T> p) throws IllegalArgumentException {
        BinaryTreeNode<T> node = validate(p);
        return node.getRight();
    }

    @Override
    public Iterable<Position<T>> children(Position<T> p) throws IllegalArgumentException {
        // ordered so that the left child is placed before the right child, either could be null
        BinaryTreeNode<T> node = validate(p);
        return new ArrayList<>(List.of(node.getLeft(), node.getRight()));
    }

    @Override
    public int numChildren(Position<T> p) throws IllegalArgumentException {
        int count = 0;
        if (leftChild(p) != null) count++;
        if (rightChild(p) != null) count++;
        return count;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterable<Position<T>> positions() {
        ArrayList<Position<T>> elements = new ArrayList<>();
        if(!isEmpty()) inorder(root(), elements);
        return elements;
    }

    public Position<T> search(T x) {
        return search(root, x);
    }

    private Position<T> search(BinaryTreeNode<T> node, T x) {
        if (node == null || node.element.compareTo(x) == 0)
            return node;
        if (node.element.compareTo(x) > 0)
            return search(node.left, x);
        else
            return search(node.right, x);
    }

    public Position<T> min() {
        if(isEmpty()) return null;
        return min(root);
    }

    private Position<T> min(BinaryTreeNode<T> x) {
        while (x.left != null)
            x = x.left;
        return x;
    }

    public Position<T> max() {
        if(isEmpty()) return null;
        return max(root);
    }

    private Position<T> max(BinaryTreeNode<T> x) {
        while (x.right != null)
            x = x.right;
        return x;
    }

    public Position<T> successor(Position<T> x) {
        BinaryTreeNode<T> node = validate(x);
        if(node.right != null) return min(node.right);
        BinaryTreeNode<T> y = node.parent;
        while (y != null && node != y.right) {
            node = y;
            y = y.parent;
        }
        return y;
    }

    public Position<T> insert(T z) {
        // insert z into BST and return the reference to that node
        if (isEmpty()) {
            root = new BinaryTreeNode<>(z, null, null, null);
            size = 1;
            return root;
        }
        return insert(root, z);
    }

    private Position<T> insert(BinaryTreeNode<T> subTree, T z) {
        if(subTree.element.compareTo(z) > 0) {
            if(subTree.left == null) {
                subTree.left = new BinaryTreeNode<>(z, subTree, null, null);
                size ++;
                return subTree.left;
            } else {
                insert(subTree.left, z);
            }
        } else if (subTree.element.compareTo(z) < 0){
            if(subTree.right == null) {
                subTree.right = new BinaryTreeNode<>(z, subTree, null, null);
                size++;
                return subTree.right;
            } else {
                insert(subTree.right, z);
            }
        }
        return null;
    }

    private void inorder(Position<T> p, ArrayList<Position<T>> elements) {
        if(leftChild(p) != null)
            inorder(leftChild(p), elements);
        elements.add(p);
        if(rightChild(p) != null)
            inorder(rightChild(p), elements);
    }

    private void transplant(BinaryTreeNode<T> u, BinaryTreeNode<T> v) {
        // replaces subtree rooted at u with subtree rooted at v
        if(root == u)
            root = v;
        else if(u.equals(u.parent.left))
            u.parent.left = v;
        else u.parent.right = v;
        if(v != null)
            v.parent = u.parent;
    }

    public void delete(Position<T> node) {
        BinaryTreeNode<T> z = validate(node);
        if (z.left == null)
            transplant(z, z.right);
        else if (z.right == null)
            transplant(z, z.left);
        else {
            BinaryTreeNode<T> y = (BinaryTreeNode<T>) successor(z);
            if (!y.parent.equals(z)) {
                transplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            transplant(z, y);
            y.left = z.left;
            y.left.parent = y;
        }
    }

    /**Methods to print a binary tree. Don't change them, don't bother to read them.
     * Just call treeString(root) to get a string representation of your binary tree
     * Colors will work only for Unix shell prompts. Fix them for Windows.
     * */
    @Override
    public String toString() {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(RED_COLOR).append(root.element).append(RESET_COLOR);

        String pointerRight = BLUE_COLOR + "R└──>" + RESET_COLOR;
        String pointerLeft = (root.right != null) ? "L├──>" : "L└──>";
        pointerLeft = YELLOW_COLOR + pointerLeft + RESET_COLOR;

        traverseNodes(sb, "", pointerLeft, root.left, root.right != null);
        traverseNodes(sb, "", pointerRight, root.right, false);

        return sb.toString();
    }

    void traverseNodes(StringBuilder sb, String padding, String pointer, BinaryTreeNode<T> node,
                              boolean hasRightSibling) {
        if (node != null) {
            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.element);

            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling) {
                paddingBuilder.append(" │  ");
            } else {
                paddingBuilder.append("   ");
            }

            String paddingForBoth = paddingBuilder.toString();
            String pointerRight = BLUE_COLOR + "R└──>" + RESET_COLOR;
            String pointerLeft = (node.right != null) ? "L├──>" : "L└──>";
            pointerLeft = YELLOW_COLOR + pointerLeft + RESET_COLOR;

            traverseNodes(sb, paddingForBoth, pointerLeft, node.left, node.right != null);
            traverseNodes(sb, paddingForBoth, pointerRight, node.right, false);
        }
    }

    private static final String YELLOW_COLOR = "\u001B[33m";
    private static final String BLUE_COLOR = "\u001B[34m";
    private static final String RESET_COLOR = "\u001B[0m";
    private static final String RED_COLOR = "\033[1;31m";
}
