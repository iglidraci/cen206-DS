import java.util.Iterator;

public interface Tree<T> {
    /**
     * The following accessor methods allow the user to navigate various positions of a tree
     * If an invalid position is sent as a parameter to any method of a tree, then an IllegalArgumentException is thrown
     * */

    /*return the position of the root of the tree*/
    Position<T> root();

    /*Returns the position of the parent of position p (or null if empty)*/
    Position<T> parent(Position<T> p) throws IllegalArgumentException;

    /*Returns an iterable collection containing the children of position p (if any)*/
    Iterable<Position<T>> children(Position<T> p) throws IllegalArgumentException;

    /* Returns the number of children of position p */
    int numChildren(Position<T> p) throws IllegalArgumentException;

    /**Query methods*/

    /*Returns true if position p has at least one child*/
    boolean isInternal(Position<T> p) throws IllegalArgumentException;
    /*Returns true if position p does not have any children.*/
    boolean isExternal(Position<T> p) throws IllegalArgumentException;
    /*Returns true if position p is the root of the tree*/
    boolean isRoot(Position<T> p) throws IllegalArgumentException;

    /**More general methods*/

    /*Returns the number of positions (and hence elements) that are contained in the tree*/
    int size();
    /*Returns true if the tree does not contain any positions*/
    boolean isEmpty();
    /*Returns the depth of a position, which is the number of ancestors of p, other than p*/
    int depth(Position<T> p) throws IllegalArgumentException;
    /*
    Returns the height of a position.
    If p is a leaf, then the height of p is 0. Otherwise, one more than the max of heights of p's children
     */
    int height(Position<T> p) throws IllegalArgumentException;
    /*Returns an iterator for all elements in the tree (so that the tree itself is Iterable)*/
    /*Returns an iterable collection of all positions of the tree*/
    Iterable<Position<T>> positions();
}
