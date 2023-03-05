import ADTs.AbstractMap;
import ADTs.KeyValue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListMap<K, V> extends AbstractMap<K, V> {
    private final ArrayList<KeyValuePair<K, V>> list = new ArrayList<>();

    /* private methods */
    private int indexOf(K key) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getKey().equals(key))
                return i;
        }
        return -1;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        if (index == -1) return null;
        return list.get(index).getValue();
    }

    @Override
    public boolean contains(K key) {
        return indexOf(key) != -1;
    }

    @Override
    public V put(K key, V value) {
        int index = indexOf(key);
        if (index == -1) {
            list.add(new KeyValuePair<>(key, value));
            return null; // since we added a new value
        }
        V oldValue = list.get(index).getValue();
        list.get(index).setValue(value);
        return oldValue;
    }

    @Override
    public V remove(K key) {
        int index = indexOf(key);
        if (index == -1) return null;
        V oldValue = list.get(index).getValue();
        list.set(index, list.get(list.size() - 1)); // replace the deleted value with the last element in the array
        list.remove(list.size() - 1); // remove the last element since it's a duplicate
        return oldValue;
    }

    /*public items() method*/
    private class ItemIterator implements Iterator<KeyValue<K, V>> {
        private int i=0;

        @Override
        public boolean hasNext() {
            return i < list.size(); // size of the array that stores all (key, value) items
        }

        @Override
        public KeyValue<K, V> next() {
            if (i == list.size()) throw new NoSuchElementException();
            return list.get(i++);
        }
    }
    private class ItemIterable implements Iterable<KeyValue<K, V>> {

        @Override
        public Iterator<KeyValue<K, V>> iterator() {
            return new ItemIterator();
        }
    }

    @Override
    public Iterable<KeyValue<K, V>> items() {
        return new ItemIterable();
    }
}
