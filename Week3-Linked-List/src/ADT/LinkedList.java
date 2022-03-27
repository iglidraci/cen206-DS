package ADT;

/*
# Main operations
prepend(value)        -> Add a node in the beginning
append(value)         -> Add a node in the end
pop()                 -> Remove a node from the end
popFirst()            -> Remove a node from the beginning
head()                -> Return the first node
tail()                -> Return the last node
remove(Node)          -> Remove Node from the list
reverse()			  -> Reverse the linked list in-place
*/

import java.util.ArrayList;
import java.util.Optional;

public abstract class LinkedList<T> {
    protected int size = 0;

    public int getSize() {
        return size;
    }

    public abstract void prepend(T value);
    public abstract void append(T value);
    public abstract T pop();
    public abstract T popFirst();
    public abstract T head();
    public abstract T tail();
    public abstract T remove(T value);
    public abstract int indexOf(T value);
    public abstract void reverse();
    public abstract ArrayList<T> toList();
    public boolean isEmpty() {
        return this.size == 0;
    }
    @Override
    public String toString() {
        Optional<String> result = toList().stream().map(Object::toString)
                .reduce((x, y) -> x + " -> " + y);
        return result.orElse("[]");
    }
}
