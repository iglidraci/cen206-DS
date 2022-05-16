public class AVL<T extends Comparable<T>> {
    private AvlNode<T> root;

    private int getHeight(AvlNode<T> node) {
        if (node == null) return -1;
        return node.getHeight();
    }
    private int getBalance(AvlNode<T> node) {
        if (node == null) return -1;
        return getHeight(node.getLeft()) - getHeight(node.getRight());
    }
    private AvlNode<T> rightRotate(AvlNode<T> node) {
        // right rotation of a node
        AvlNode<T> parent = node.getParent();
        AvlNode<T> leftChild = node.getLeft();
        AvlNode<T> rightChildOfLeftChild = leftChild.getRight();
        leftChild.setRight(node);
        node.setParent(leftChild);
        node.setLeft(rightChildOfLeftChild);
        if (rightChildOfLeftChild != null) rightChildOfLeftChild.setParent(node);
        if (parent == null) {
            this.root = leftChild;
            leftChild.setParent(null);
        } // root node
        else {
            if (parent.getLeft() == node)
                parent.setLeft(leftChild);
            else
                parent.setRight(leftChild);
            leftChild.setParent(parent);
        }
        node.setHeight(1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight())));
        leftChild.setHeight(1 + Math.max(getHeight(leftChild.getLeft()), getHeight(leftChild.getRight())));
        return leftChild;
    }
    private AvlNode<T> leftRotate(AvlNode<T> node) {
        // left rotation of a node
        AvlNode<T> parent = node.getParent();
        AvlNode<T> rightChild = node.getRight();
        AvlNode<T> leftChildOfRightChild = rightChild.getLeft();
        rightChild.setLeft(node);
        node.setParent(rightChild);
        node.setRight(leftChildOfRightChild);
        if (leftChildOfRightChild != null) leftChildOfRightChild.setParent(node);
        if (parent == null) {
            this.root = rightChild;

        } else {
            if (parent.getLeft() == node)
                parent.setLeft(rightChild);
            else
                parent.setRight(rightChild);
        }
        node.setHeight(1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight())));
        rightChild.setHeight(1 + Math.max(getHeight(rightChild.getLeft()), getHeight(rightChild.getRight())));
        return rightChild;
    }
    public void insert(T key) {
        this.root = insert(key, root);
    }

    private AvlNode<T> insert(T key, AvlNode<T> subRoot) {
        if (subRoot == null)
            return new AvlNode<>(key);
        else if (subRoot.getValue().compareTo(key) > 0)
            subRoot.setLeft(insert(key, subRoot.getLeft()));
        else if (subRoot.getValue().compareTo(key) < 0)
            subRoot.setRight(insert(key, subRoot.getRight()));
        subRoot.setHeight(1 + Math.max(getHeight(subRoot.getLeft()), getHeight(subRoot.getRight())));
        int balanceFactor = getBalance(subRoot);
        if (balanceFactor > 1) {
            int res = subRoot.getLeft().getValue().compareTo(key);
            if (res > 0) return rightRotate(subRoot); // simple right rotation
            else if (res < 0) {
                // left right rotation
                subRoot.setLeft(leftRotate(subRoot.getLeft()));
                return rightRotate(subRoot);
            }
        } // left heavy
        else if (balanceFactor < - 1) {
            int res = subRoot.getRight().getValue().compareTo(key);
            if (res > 0) {
                subRoot.setRight(rightRotate(subRoot.getRight()));
                return leftRotate(subRoot);
            } else return leftRotate(subRoot);
        } // right heavy
        return subRoot;
    }

    public void printTree() {
        inorder(this.root);
    }

    private void inorder(AvlNode<T> treeNode) {
        if (treeNode == null) return;
        inorder(treeNode.getLeft());
        System.out.print(treeNode.getValue() + " ");
        inorder(treeNode.getRight());
    }

    /*toString() of the avl tree*/

    private void traverseNodes(StringBuilder sb, String padding, String pointer, AvlNode<T> node,
                               boolean hasRightSibling) {
        if (node != null) {
            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.getValue());

            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling) {
                paddingBuilder.append(" │  ");
            } else {
                paddingBuilder.append("   ");
            }

            String paddingForBoth = paddingBuilder.toString();
            String pointerRight = "R└──>";
            String pointerLeft = (node.getRight() != null) ? "L├──>" : "L└──>";

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

        String pointerRight = "R└──>";
        String pointerLeft = (root.getRight() != null) ? "L├──>" : "L└──>";

        traverseNodes(sb, "", pointerLeft, root.getLeft(), root.getRight() != null);
        traverseNodes(sb, "", pointerRight, root.getRight(), false);

        return sb.toString();
    }
}
