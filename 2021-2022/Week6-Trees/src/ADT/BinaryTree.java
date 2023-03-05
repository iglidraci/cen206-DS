package ADT;

public interface BinaryTree<T> extends Tree<T> {
    // return p's left child
    Position<T> leftChild(Position<T> position);
    // return p's right child
    Position<T> rightChild(Position<T> position);
    // return the sibling of the given position, null if there's none
    Position<T> sibling(Position<T> position);
}
