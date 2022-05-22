import ADTs.Map;
import ADTs.Set;

public class HashSet<K> implements Set<K> {
    private Map<K, K> hashMap;
    public HashSet(int capacity, int p) {
        hashMap = new ChainingHashMap<>(capacity, p);
    }
    public HashSet(int capacity) {
        hashMap = new ChainingHashMap<>(capacity);
    }
    public HashSet() {
        hashMap = new ChainingHashMap<>();
    }
    @Override
    public void add(K key) {
        if (!hashMap.contains(key)) hashMap.put(key, key);
    }

    @Override
    public K remove(K key) {
        return hashMap.remove(key);
    }

    @Override
    public boolean contains(K key) {
        return hashMap.contains(key);
    }

    @Override
    public Iterable<K> iterator() {
        return hashMap.keys();
    }

    @Override
    public void unionWith(Set<K> s) {
        for(K key : s.iterator())
            add(key);
    }

    @Override
    public void intersectWith(Set<K> s) {
        ChainingHashMap<K, K> newMap = new ChainingHashMap<>();
        for(K key : this.iterator())
            if (s.contains(key))
                newMap.put(key, key);
        this.hashMap = newMap;
    }

    @Override
    public void subtractWith(Set<K> s) {
        for (K key : s.iterator())
            if (contains(key))
                remove(key);
    }

    @Override
    public int size() {
        return hashMap.size();
    }

    @Override
    public boolean isEmpty() {
        return hashMap.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (K key : iterator())
            sb.append(String.format("%s,", key));
        return sb.append("]").toString();
    }
}
