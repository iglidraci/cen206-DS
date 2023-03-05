import ADT.AbstractBinaryTree;
import ADT.Position;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;

public class LinkedBinaryTree<T> extends AbstractBinaryTree<T> {
    private LinkedStructure<T> root;
    private int size = 0;
    private LinkedStructure<T> validate (Position<T> position){
        if (!(position instanceof LinkedStructure<T> node)) // pattern variable
            throw new IllegalArgumentException("Not a valid position type");
        if (node.getParent() == node) // our convention for deleted node
            throw new IllegalArgumentException("This position is no longer in the tree");
        return node;
    }
    @Override
    public Position<T> leftChild(Position<T> position) {
        LinkedStructure<T> node = validate(position);
        return node.getLeft();
    }

    @Override
    public Position<T> rightChild(Position<T> position) {
        LinkedStructure<T> node = validate(position);
        return node.getRight();
    }

    @Override
    public Position<T> root() {
        return this.root;
    }

    @Override
    public Position<T> parent(Position<T> position) throws IllegalArgumentException {
        LinkedStructure<T> node = validate(position);
        return node.getParent();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return this.breadthFirst().iterator();
    }
    public Position<T> addRoot(T value) throws IllegalStateException {
        if (!isEmpty()) throw new IllegalStateException("Tree is not empty");
        this.root = new LinkedStructure<>(value);
        size = 1;
        return root;
    }
    public Position<T> addLeft(Position<T> position, T value) throws IllegalArgumentException {
        // creates a left child of the given position
        // the left child should store the given value as an argument
        LinkedStructure<T> parent = validate(position);
        if (parent.getLeft() != null) throw new IllegalArgumentException("Position already has a left child");
        LinkedStructure<T> child = new LinkedStructure<>(value);
        child.setParent(parent);
        parent.setLeft(child);
        size++;
        return child;
    }
    public Position<T> addRight(Position<T> position, T value) throws IllegalArgumentException {
        // creates a right child of the given position
        // the right child should store the given value as an argument
        LinkedStructure<T> parent = validate(position);
        if (parent.getRight() != null) throw new IllegalArgumentException("ADT.Position already has a right child");
        LinkedStructure<T> child = new LinkedStructure<>(value);
        child.setParent(parent);
        parent.setRight(child);
        size++;
        return child;
    }
    public void update(Position<T> position, T element) {
        // update the element inside the give position
        LinkedStructure<T> node = validate(position);
        node.setElement(element);
    }
    public void attach(Position<T> p, LinkedBinaryTree<T> t1,
                       LinkedBinaryTree<T> t2) throws IllegalArgumentException{
        // attach trees t1 and t2 as left and right subtrees of leaf node p
        LinkedStructure<T> node = validate(p);
        if (!isLeaf(p)) throw new IllegalArgumentException("ADT.Position should be a leaf node");
        if (!t1.isEmpty()) {
            t1.root.setParent(node);
            node.setLeft(t1.root);
            this.size += t1.size();
            t1.root = null;
            t1.size = 0;
        }
        if (!t2.isEmpty()) {
            t2.root.setParent(node);
            node.setRight(t2.root);
            this.size += t2.size();
            t2.root = null;
            t2.size = 0;
        }
    }
    public T remove(Position<T> p) throws IllegalArgumentException {
        // removes the node at Position p and replaces it with its child if any
        // return the element from the deleted position
        LinkedStructure<T> nodeToDelete = validate(p);
        // we will fix this
        if (numberChildren(p) == 2)
            throw new IllegalArgumentException("Position has two children");
        LinkedStructure<T> child = nodeToDelete.getLeft() != null ? nodeToDelete.getLeft() : nodeToDelete.getRight();
        if (child != null)
            child.setParent(nodeToDelete.getParent()); // child's grandparent becomes its parent
        if (nodeToDelete == root)
            root = child;
        else {
            LinkedStructure<T> parent = nodeToDelete.getParent();
            if (nodeToDelete == parent.getLeft())
                parent.setLeft(child);
            else
                parent.setRight(child);
        }
        size--;
        nodeToDelete.setLeft(null);
        nodeToDelete.setRight(null);
        nodeToDelete.setParent(nodeToDelete); // our convention for deleting a node
        T element = nodeToDelete.getElement();
        nodeToDelete.setElement(null);
        return element;
    }
    /*inorder traversal*/
    public ArrayList<T> inorder() {
        ArrayList<T> nodes = new ArrayList<>(size());
        inorder(root, nodes);
        return nodes;
    }
    private void inorder(LinkedStructure<T> p, ArrayList<T> nodes) {
        LinkedStructure<T> leftChild = p.getLeft();
        if (leftChild != null)
            inorder(leftChild, nodes);
        nodes.add(p.getElement());
        LinkedStructure<T> rightChild = p.getRight();
        if (rightChild != null)
            inorder(rightChild, nodes);
    }

    /*exercises*/
    public double sumOfLeftLeaves() {
        if (!(root.getElement() instanceof Number)) throw new IllegalStateException("Nodes should extend Number class");
        double[] sum = {0};
        postorderSum(root, sum);
        return sum[0];
    }

    private void postorderSum(Position<T> current, double[] sum) {
        for(Position<T> child : children(current))
            postorderSum(child, sum);
        if (isLeaf(current) && ((LinkedStructure<T>)current).getParent().getLeft() == current)
            sum[0] += ((Number)current.getElement()).doubleValue();
    }

    public void invert() {
        invert(root);
    }
    private void invert(LinkedStructure<T> root) {
        if (root == null) return;
        LinkedStructure<T> temp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(temp);
        invert(root.getLeft());
        invert(root.getRight());
    }
    public boolean isSymmetric() {
        if (isEmpty()) return true;
        return isSymmetric(root.getLeft(), root.getRight());
    }

    private boolean isSymmetric (LinkedStructure<T> left, LinkedStructure<T> right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.getElement() == right.getElement() && isSymmetric(left.getLeft(), right.getRight())
                && isSymmetric(left.getRight(), right.getLeft());
    }

    public double sumRootToLeafNumbers() {
        /*
        * Return the total sum of all root-to-leaf numbers
        * */
        if (!(root.getElement() instanceof Number)) throw new IllegalStateException("Nodes should extend Number class");
        return sumRootToLeafNumbers(root, 0.);
    }

    private double sumRootToLeafNumbers(LinkedStructure<T> current, double currentSum) {
        if (current == null) return 0;
        double value = ((Number)current.getElement()).doubleValue();
        currentSum = currentSum*10 + value;
        if (isLeaf(current)) return currentSum;
        double left = sumRootToLeafNumbers(current.getLeft(), currentSum); // traverse left
        double right = sumRootToLeafNumbers(current.getRight(), currentSum); // traverse right
        return left + right;
    }

    public boolean isSubtree(LinkedStructure<T> subRoot) {
        /*
        * return true if there is a subtree of root with the same structure
        * and node values of subRoot and false otherwise
        * */
        Queue<LinkedStructure<T>> queue = new ArrayDeque<>(size());
        queue.add(root);
        while (!queue.isEmpty()) {
            LinkedStructure<T> current = queue.remove();
            if (areIdentical(current, subRoot)) return true;
            if (current.getLeft() != null) queue.add(current.getLeft());
            if (current.getRight() != null) queue.add(current.getRight());
        }
        return false;
    }

    private boolean areIdentical(LinkedStructure<T> t1, LinkedStructure<T> t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return t1.getElement().equals(t2.getElement())  && areIdentical(t1.getLeft(), t2.getLeft())
                && areIdentical(t1.getRight(), t2.getRight());
    }

    /*toString() of the binary tree*/

    private void traverseNodes(StringBuilder sb, String padding, String pointer, LinkedStructure<T> node,
                              boolean hasRightSibling) {
        if (node != null) {
            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.getElement());

            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling) {
                paddingBuilder.append("│  ");
            } else {
                paddingBuilder.append("   ");
            }

            String paddingForBoth = paddingBuilder.toString();
            String pointerRight = "└──>";
            String pointerLeft = (node.getRight() != null) ? "├──>" : "└──>";

            traverseNodes(sb, paddingForBoth, pointerLeft, node.getLeft(), node.getRight() != null);
            traverseNodes(sb, paddingForBoth, pointerRight, node.getRight(), false);
        }
    }

    @Override
    public String toString() {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.getElement());

        String pointerRight = "└──>";
        String pointerLeft = (root.getRight() != null) ? "├──>" : "└──>";

        traverseNodes(sb, "", pointerLeft, root.getLeft(), root.getRight() != null);
        traverseNodes(sb, "", pointerRight, root.getRight(), false);

        return sb.toString();
    }
}
