import ADTs.AbstractHashMap;
import ADTs.KeyValue;

import java.util.LinkedList;

public class ChainingHashMap<K, V> extends AbstractHashMap<K, V> {
    private ListMap<K, V>[] table; // create an array with ListMap
    public ChainingHashMap() {
        super();
    }
    public ChainingHashMap(int capacity) {
        super(capacity);
    }
    public ChainingHashMap(int capacity, int p) {
        super(capacity, p);
    }
    @Override
    protected void createTable() {
        table = (ListMap<K, V>[]) new ListMap[this.capacity];
    }

    @Override
    protected V hashTableGet(int hValue, K key) {
        if (table[hValue] == null) return null; // there is no list at all saved in that position
        return table[hValue].get(key);
    }

    @Override
    protected V hashTablePut(int hValue, K key, V value) {
        if (table[hValue] == null) {
            table[hValue] = new ListMap<>();
        } // we created a list in that position
        int prevSize = table[hValue].size();
        V oldValue = table[hValue].put(key, value);
        if (table[hValue].size() > prevSize)
            this.size++;
        return oldValue;
    }

    @Override
    protected V hashTableRemove(int hValue, K key) {
        if (table[hValue] == null) return null;
        int prevSize = table[hValue].size();
        V oldValue = table[hValue].remove(key);
        if (prevSize > table[hValue].size())
            this.size--;
        return oldValue;
    }

    @Override
    public boolean contains(K key) {
        int hValue = hashValue(key);
        if (table[hValue] == null) return false;
        return table[hValue].contains(key);
    }

    @Override
    public Iterable<KeyValue<K, V>> items() {
        LinkedList<KeyValue<K, V>> items = new LinkedList<>();
        for (int i = 0; i < this.capacity; i++) {
            if (table[i] != null) {
                for(KeyValue<K, V> item : table[i].items())
                    items.addLast(item);
            }
        }
        return items;
    }
}
