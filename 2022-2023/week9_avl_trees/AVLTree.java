public class AVLTree<T extends Comparable<T>> {
    private static class AvlNode<T extends Comparable<T>> {
        private int height = 0; // by convention leaves have height 0
        private AvlNode<T> left;
        private AvlNode<T> right;
        private AvlNode<T> parent;
        private T value;

        public AvlNode(T value, AvlNode<T> left, AvlNode<T> right, AvlNode<T> parent) {
            this.value = value;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        public AvlNode(T value) {
            this.value = value;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public AvlNode<T> getLeft() {
            return left;
        }

        public void setLeft(AvlNode<T> left) {
            this.left = left;
        }

        public AvlNode<T> getRight() {
            return right;
        }

        public void setRight(AvlNode<T> right) {
            this.right = right;
        }

        public AvlNode<T> getParent() {
            return parent;
        }

        public void setParent(AvlNode<T> parent) {
            this.parent = parent;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public int getHeight() {
            return height;
        }
    }

    private AvlNode<T> root;

    private int getHeight(AvlNode<T> node) {
        if (node == null) return -1;
        return node.getHeight();
    }
    private int getBalance(AvlNode<T> node) {
        /*
        positive number means left heavy
        negative number means right heavy
        0 means balanced
         */
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
