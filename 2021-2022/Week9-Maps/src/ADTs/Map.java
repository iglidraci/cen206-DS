package ADTs;

public interface Map<K, V> {
    boolean isEmpty();
    int size();
    V get(K key);
    // return whether key exists or not in the map
    boolean contains(K key);
    // return the old value if any, otherwise return null
    V put(K key, V value);
    V remove(K key);
    Iterable<K> keys();
    Iterable<V> values();
    // return an iterable of (key, value) items
    Iterable<KeyValue<K, V>> items();
}
