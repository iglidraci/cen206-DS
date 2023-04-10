public interface BinaryTree<T> extends Tree<T> {
    /*Returns the Position of p's left child (or null if no child exists)*/
    Position<T> left(Position<T> p) throws IllegalArgumentException;
    /*Returns the Position of p's right child (or null if no child exists)*/
    Position<T> right(Position<T> p) throws IllegalArgumentException;
    /*Returns the Position of p's sibling (or null if no child exists)*/
    Position<T> sibling(Position<T> p) throws IllegalArgumentException;
}
