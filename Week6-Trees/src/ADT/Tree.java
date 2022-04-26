package ADT;

public interface Tree<T> extends Iterable<T> {
    /*accessor methods, navigate the various positions of a tree*/
    Position<T> root();
    Position<T> parent(Position<T> position) throws IllegalArgumentException;
    Iterable<Position<T>> children(Position<T> position) throws IllegalArgumentException;
    int numberChildren(Position<T> position) throws IllegalArgumentException;
    /*query methods*/
    boolean isInternal(Position<T> position);
    boolean isLeaf(Position<T> position);
    boolean isRoot(Position<T> position);
    /* general methods */
    int depth(Position<T> position);
    int height(Position<T> position);
    int size();
    boolean isEmpty();
}
