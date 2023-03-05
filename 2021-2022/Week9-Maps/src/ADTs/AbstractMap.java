package ADTs;

import java.util.Iterator;

public abstract class AbstractMap<K, V> implements Map<K, V> {
    public static class KeyValuePair<K, V> implements KeyValue<K, V> {
        private K key;
        private V value;
        public KeyValuePair(){}
        public KeyValuePair(K key, V value) {
            this.key = key;
            this.value = value;
        }
        /* part of the KeyValue interface */
        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }
        public V setValue(V value) {
            V old = this.value;
            this.value = value;
            return old;
        }
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }
    /* support for keys() method */
    private class KeyIterator implements Iterator<K> {
        // items() method from the Map interface
        private final Iterator<KeyValue<K, V>> items = items().iterator();

        @Override
        public boolean hasNext() {
            return this.items.hasNext();
        }

        @Override
        public K next() {
            return this.items.next().getKey();
        }
    }
    private class KeyIterable implements Iterable<K> {

        @Override
        public Iterator<K> iterator() {
            return new KeyIterator();
        }
    }

    @Override
    public Iterable<K> keys() {
        return new KeyIterable();
    }
    /* end of keys() iterable support */

    /* support for values() method */
    private class ValueIterator implements Iterator<V> {
        // items() method from the Map interface
        private final Iterator<KeyValue<K, V>> items = items().iterator();

        @Override
        public boolean hasNext() {
            return this.items.hasNext();
        }

        @Override
        public V next() {
            return this.items.next().getValue();
        }
    }
    private class ValueIterable implements Iterable<V> {

        @Override
        public Iterator<V> iterator() {
            return new ValueIterator();
        }
    }

    @Override
    public Iterable<V> values() {
        return new ValueIterable();
    }
    /* end of values() iterable support */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(var keyValue : items())
            sb.append(String.format("%s -> %s\n", keyValue.getKey().toString(), keyValue.getValue().toString()));
        return sb.toString();
    }
}
