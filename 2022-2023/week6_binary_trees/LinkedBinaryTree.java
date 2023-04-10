import org.w3c.dom.Node;

public class LinkedBinaryTree<T> extends AbstractBinaryTree<T> {

    // nested TreeNode class
    private static class TreeNode<T> implements Position<T> {
        private T element;
        private TreeNode<T> parent;
        private TreeNode<T> left;
        private TreeNode<T> right;
        public TreeNode(T t, TreeNode<T> above, TreeNode<T> leftChild, TreeNode<T> rightChild) {
            element = t;
            parent = above;
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

        public TreeNode<T> getParent() {
            return parent;
        }

        public void setParent(TreeNode<T> parent) {
            this.parent = parent;
        }

        public TreeNode<T> getLeft() {
            return left;
        }

        public void setLeft(TreeNode<T> left) {
            this.left = left;
        }

        public TreeNode<T> getRight() {
            return right;
        }

        public void setRight(TreeNode<T> right) {
            this.right = right;
        }
        @Override
        public String toString() {
            return element.toString();
        }
    } // end of nested TreeNode class

    protected TreeNode<T> root = null;
    private int size = 0;
    /**Validate the position of a tree and returns it as a TreeNode*/
    protected TreeNode<T> validate(Position<T> p) throws IllegalArgumentException {
        if (!(p instanceof TreeNode)) throw new IllegalArgumentException("Not valid position type");
        TreeNode<T> node = (TreeNode<T>) p;
        if(node.getParent() == node) // convention for defunct node
            throw new IllegalArgumentException("p is no longer in the tree");
        return node;
    }
    @Override
    public Position<T> left(Position<T> p) throws IllegalArgumentException {
        TreeNode<T> pos = validate(p);
        return pos.getLeft();
    }

    @Override
    public Position<T> right(Position<T> p) throws IllegalArgumentException {
        TreeNode<T> pos = validate(p);
        return pos.getRight();
    }

    @Override
    public Position<T> root() {
        return root;
    }

    @Override
    public Position<T> parent(Position<T> p) throws IllegalArgumentException {
        TreeNode<T> pos = validate(p);
        return pos.getParent();
    }

    @Override
    public int size() {
        return size;
    }

    // update methods supported by this class

    /** Places element t at the root of an empty tree and returns its new Position. */
    public Position<T> addRoot(T t) throws IllegalStateException {
        if(!isEmpty()) throw new IllegalStateException("Tree is not empty");
        root = new TreeNode<>(t, null, null, null);
        size = 1;
        return root;
    }

    /**Creates a new left child of Position p storing element t; returns its Position*/
    public Position<T> addLeft(Position<T> p, T t) throws IllegalArgumentException {
        TreeNode<T> parent = validate(p);
        if(parent.getLeft() != null) throw new IllegalArgumentException("p already has a left child");
        TreeNode<T> child = new TreeNode<>(t, parent, null, null);
        parent.setLeft(child);
        size++;
        return child;
    }

    /**Creates a new right child of Position p storing element t; returns its Position*/
    public Position<T> addRight(Position<T> p, T t) throws IllegalArgumentException {
        TreeNode<T> parent = validate(p);
        if(parent.getRight() != null) throw new IllegalArgumentException("p already has a right child");
        TreeNode<T> child = new TreeNode<>(t, parent, null, null);
        parent.setRight(child);
        size++;
        return child;
    }

    /**Replaces the element at Position p with t.*/
    public void set(Position<T> p, T t) throws IllegalArgumentException {
        TreeNode<T> node = validate(p);
        node.setElement(t);
    }

    /**Attaches trees t1 and t2 as left and right subtrees of external p*/
    public void attach(Position<T> p, LinkedBinaryTree<T> t1, LinkedBinaryTree<T> t2) throws IllegalArgumentException {
        TreeNode<T> node = validate(p);
        if(!isExternal(node)) throw new IllegalArgumentException("p must be external node");
        size += t1.size() + t2.size();
        if(!t1.isEmpty()) {
            t1.root.setParent(node); // attach t1 as left subtree of node
            node.setLeft(t1.root);
            t1.root = null;
            t1.size = 0;
        }
        if(!t2.isEmpty()) {
            t1.root.setParent(node); // attach t2 as right subtree of node
            node.setRight(t1.root);
            t1.root = null;
            t1.size = 0;
        }
    }

    /**Removes the node at Position p and replaces it with its child, if any.*/
    public void remove(Position<T> p) throws IllegalArgumentException {
        TreeNode<T> node = validate(p);
        if(numChildren(p) == 2)
            throw new IllegalArgumentException("p has two children");
        TreeNode<T> child = (node.getLeft() != null ? node.getLeft() : node.getRight());
        if(child != null)
            child.setParent(node.getParent());
        if(node == root)
            root = child;
        else {
            TreeNode<T> parent = node.getParent();
            if(node == parent.getLeft())
                parent.setLeft(child);
            else
                parent.setRight(child);
        }
        size--;
        node.setElement(null);
        node.setLeft(null);
        node.setRight(null);
        node.setParent(node); // our convention for defunct node
    }

    /**Print parenthesized representation of tree*/
    public void parentheticRep() {
        /*
        * The parenthetic string representation P(T) of binary tree T is recursively defined.
        * If T consists of a single position p, then P(T ) = p.getElement( )
        * Otherwise, P(T)= p.getElement() + "("+P(leftChild) + "," + P(rightChild)+")"
        * */
        parentheticRep(root);
        System.out.println();
    }

    private void parentheticRep(Position<T> p) {
        System.out.print(p.getElement() + " ");
        if(isInternal(p)) {
            boolean firstTime = true;
            for(Position<T> child : children(p)) {
                System.out.print((firstTime ? " (" : ", "));
                firstTime = false;
                parentheticRep(child);
            }
            System.out.print(")");
        }
    }



    @Override
    public Iterable<Position<T>> positions() {
        return inorder();
    }
}
