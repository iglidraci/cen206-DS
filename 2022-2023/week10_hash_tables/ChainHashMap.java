import java.util.ArrayList;

// A concrete hash map implementation using chaining.
public class ChainHashMap<K, V> extends AbstractHashMap<K, V> {
    private ListMap<K, V>[] table;

    /**Creates an empty table having length equal to current capacity.*/
    @Override
    protected void createTable() {
        table = (ListMap<K, V>[]) new ListMap[m];
    }

    /**Returns value associated with key in slot with the given hash value, or else null*/
    @Override
    protected V slotGet(int hash, K key) {
        ListMap<K, V> slot = table[hash];
        if(slot == null) return null;
        return slot.get(key);
    }

    @Override
    protected void slotPut(int hash, K key, V value) {
        ListMap<K, V> slot = table[hash];
        if(slot == null)
            slot = table[hash] = new ListMap<>();
        int oldSize = slot.size();
        slot.put(key, value);
        n += (slot.size() - oldSize);
    }

    @Override
    protected V slotRemove(int hash, K key) {
        ListMap<K, V> slot = table[hash];
        if(slot == null) return null;
        int oldSize = slot.size();
        V oldValue = slot.remove(key);
        n -= (oldSize - slot.size());
        return oldValue;
    }

    @Override
    public Iterable<Item<K, V>> items() {
        ArrayList<Item<K, V>> buffer = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            if(table[i] != null)
                for(Item<K, V> item : table[i].items())
                    buffer.add(item);
        }
        return buffer;
    }
}
