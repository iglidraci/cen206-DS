import java.util.ArrayList;

public class BST<T extends Comparable<T>> {
    private Node<T> root;
    private int size = 0;
    public boolean contains(T key) {
        // call recursive function
        return contains(key, root);
    }
    private boolean contains(T key, Node<T> root) {
        if (root == null) return false;
        int result = root.getValue().compareTo(key);
        if (result == 0) return true;
        else if (result > 0)
            return contains(key, root.getLeft());
        else return contains(key, root.getRight());
    }
    public boolean isEmpty() {
        return this.size == 0;
    }
    public void insert(T key) {
        if (isEmpty()) {
            root = new Node<>(key);
            this.size++;
        }
        else insert(key, root);
    }

    private void insert(T key, Node<T> subRoot) {
        int result = subRoot.getValue().compareTo(key);
        if (result > 0) { // go left
            if (subRoot.getLeft() == null) {
                subRoot.setLeft(new Node<>(key, null, null, subRoot));
                size++;
            }
            else insert(key, subRoot.getLeft());
        }
        else if (result < 0) { // go right
            if (subRoot.getRight() == null) {
                subRoot.setRight(new Node<>(key, null, null, subRoot));
                size++;
            }
            else insert(key, subRoot.getRight());
        }
    }

    public void delete(T key) {
        if (isEmpty())
            throw new IllegalStateException("Tree is empty");
        delete(key, root);
    }

    private void delete(T key, Node<T> subRoot) {
        if (subRoot == null) throw new IllegalArgumentException("Key is not in the tree");
        int result = subRoot.getValue().compareTo(key);
        if (result > 0)
            delete(key, subRoot.getLeft());
        else if (result < 0)
            delete(key, subRoot.getRight());
        else { // we found our key
            int children = childrenCount(subRoot);
            if (children == 0) {
                if (subRoot.getParent() == null){
                    this.root = null;
                } // leaf and root of BST
                else if (subRoot == subRoot.getParent().getRight()) {
                    subRoot.getParent().setRight(null);
                } // subRoot is right child
                else {
                    subRoot.getParent().setLeft(null);
                } // subRoot is left child
                this.size--;
            } // case 1, node you are trying to delete is a leaf node
            else if (children == 1) {
                Node<T> onlyChild = getFirstChild(subRoot);
                if (subRoot.getParent() == null) {
                    this.root = onlyChild;
                } // root node with one child only to be deleted
                else {
                    if (subRoot.getParent().getLeft() == subRoot)
                        subRoot.getParent().setLeft(onlyChild);
                    else
                        subRoot.getParent().setRight(onlyChild);
                }
                this.size--;
            } // case 2, node has one child only
            else {
                Node<T> predecessor = predecessor(subRoot);
                subRoot.setValue(predecessor.getValue());
                delete(predecessor.getValue(), predecessor);
            } // case 3, two children
        }
    }

    private Node<T> predecessor(Node<T> node) {
        return rightMost(node.getLeft());
    }

    private Node<T> rightMost(Node<T> node) {
        if (node.getRight() == null)
            return node;
        return rightMost(node.getRight());
    }

    private Node<T> getFirstChild(Node<T> node) {
        if (node.getLeft() != null) return node.getLeft();
        else if (node.getRight() != null) return node.getRight();
        else return null;
    }

    private int childrenCount(Node<T> node) {
        int total = 0;
        if (node.getRight() != null) total++;
        if (node.getLeft() != null) total++;
        return total;
    }

    public int size() {
        return size;
    }

    /*inorder traversal*/
    public ArrayList<T> inorder() {
        ArrayList<T> nodes = new ArrayList<>(size());
        inorder(root, nodes);
        return nodes;
    }
    private void inorder(Node<T> p, ArrayList<T> nodes) {
        Node<T> leftChild = p.getLeft();
        if (leftChild != null)
            inorder(leftChild, nodes);
        nodes.add(p.getValue());
        Node<T> rightChild = p.getRight();
        if (rightChild != null)
            inorder(rightChild, nodes);
    }

    /* exercises */

    public T smallestValue(int i) {
        // smallest values are 1-indexed
        ArrayList<T> nodes = this.inorder();
        if (i > nodes.size()) throw new IllegalArgumentException("Not enough elements in the tree");
        return nodes.get(i - 1);
    }

    /*toString() of the binary search tree*/

    private void traverseNodes(StringBuilder sb, String padding, String pointer, Node<T> node,
                               boolean hasRightSibling) {
        if (node != null) {
            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.getValue());

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
        sb.append(root.getValue());

        String pointerRight = "└──>";
        String pointerLeft = (root.getRight() != null) ? "├──>" : "└──>";

        traverseNodes(sb, "", pointerLeft, root.getLeft(), root.getRight() != null);
        traverseNodes(sb, "", pointerRight, root.getRight(), false);

        return sb.toString();
    }
}
