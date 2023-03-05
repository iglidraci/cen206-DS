import ADTs.Cache;
import ADTs.Map;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LRUCache<K, V> implements Cache<K, V> {
    private final Map<K, V> data;
    private final int capacity;
    private final Deque<K> deque = new ArrayDeque<>();
    public LRUCache(int capacity) {
        this.capacity = capacity;
        data = new ChainingHashMap<>(this.capacity * 2);
    }
    public V get(K key) {
        if (!this.data.contains(key)) return null;
        popAndAppend(key);
        return this.data.get(key);
    }
    public void put(K key, V value) {
        if (this.data.contains(key)) {
            popAndAppend(key);
        } else {
            if (this.data.size() >= this.capacity) {
                K lru = this.deque.removeFirst();
                this.data.remove(lru);
            }
            this.deque.addLast(key);
        }
        this.data.put(key, value);
    }

    private void popAndAppend(K key) {
        // move the key from the left of the queue to the right
        // increase the LRU coefficient
        Stack<K> stack = new Stack<>();
        while (true) {
            K lru = this.deque.removeFirst();
            if (lru.equals(key)) {
                this.deque.addLast(lru);
                break;
            }
            else
                stack.push(lru);
        }
        while (!stack.isEmpty())
            this.deque.addFirst(stack.pop());
        /*
        * Naive & Worst solution possible
        * */
    }
}
