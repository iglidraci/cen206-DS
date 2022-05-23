package ADTs;

import java.util.function.Predicate;

public interface Set<K> {
    void add(K key);
    K remove(K key);
    boolean contains(K key);
    Iterable<K> iterator();
    void unionWith(Set<K> s);
    void intersectWith(Set<K> s);
    void subtractWith(Set<K> s);
    int size();
    boolean isEmpty();
    // for fun, ignore it
    void removeWhere(Predicate<K> predicate);
}
