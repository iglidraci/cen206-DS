import ADTs.Cache;
import ADTs.Map;

public class DoubleLinkedLRU<K, V> implements Cache<K, V> {
    private final Map<K, DLLNode<K, V>> data = new ChainingHashMap<>();
    private final int capacity;
    private final DLLNode<K, V> head;
    private final DLLNode<K, V> tail;
    private static class DLLNode<K, V> {
        /*definition of a double linked list node*/
        K key;
        V value;
        DLLNode<K, V> next;
        DLLNode<K, V> prev;
        DLLNode() {}
        DLLNode(K key, V value, DLLNode<K, V> next, DLLNode<K, V> prev) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
    public DoubleLinkedLRU(int capacity) {
        this.capacity = capacity;
        // let head and tail be sort of sentinels
        // each node in the double linked list will be placed between head and tail
        this.head = new DLLNode<>();
        this.tail = new DLLNode<>(null, null, null, this.head);
        this.head.next = this.tail;
    }
    @Override
    public V get(K key) {
        if (!this.data.contains(key)) return null;
        else {
            DLLNode<K, V> node = this.data.get(key);
            removeFromDLL(node);
            addToDLLTail(node);
            return node.value;
        }
    }

    private void addToDLLTail(DLLNode<K, V> node) {
        DLLNode<K, V> last = this.tail.prev;
        last.next = node;
        node.prev = last;
        node.next = this.tail;
        this.tail.prev = node;
    }

    private void removeFromDLL(DLLNode<K, V> node) {
        DLLNode<K, V> prev = node.prev;
        DLLNode<K, V> next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    @Override
    public void put(K key, V value) {
        // TBD
        if (this.data.contains(key)) {
            removeFromDLL(this.data.get(key));
        }
        DLLNode<K, V> node = new DLLNode<>(key, value, null, null);
        addToDLLTail(node);
        this.data.put(key, node);
        if (this.data.size() > this.capacity) {
            K keyToEvict = this.head.next.key;
            removeFromDLL(this.head.next); // remove the first value (LRU)
            this.data.remove(keyToEvict);
        }
    }
}
