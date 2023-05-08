import java.util.ArrayList;

public class ListMap<K, V> extends AbstractMap<K, V> {
    /** Underlying storage for the map of entries. */
    private final ArrayList<MapItem<K, V>> table = new ArrayList<>();
    // private utility
    /** Returns the index of an entry with equal key, or −1 if none found */
    private int findIndex(K key) {
        for (int i = 0; i < table.size(); i++) {
            if(table.get(i).getKey().equals(key))
                return i;
        }
        return -1;
    }
    @Override
    public int size() {
        return table.size();
    }
    /** Returns the value associated with the specified key (or else null). */
    @Override
    public V get(K key) {
        int i = findIndex(key);
        if(i == -1) return null;
        return table.get(i).getValue();
    }
    /**Associates given value with given key, replacing a previous value if it already exists.*/
    @Override
    public void put(K key, V value) {
        int i = findIndex(key);
        if(i == -1) {
            table.add(new MapItem<>(key, value)); // add new item
        } else { // key already exists
            table.get(i).setValue(value); // replaced value is returned
        }
    }

    @Override
    public V remove(K key) {
        int i = findIndex(key);
        if(i == -1) return null; // no key found to remove
        V value = table.get(i).getValue();
        table.remove(i);
        return value;
    }

    @Override
    public Iterable<Item<K, V>> items() {
        ArrayList<Item<K, V>> items = new ArrayList<>();
        for(MapItem<K, V> item : table)
            items.add(item);
        return items;
    }
}
