package ADTs;

import java.util.LinkedList;
import java.util.Random;

public abstract class AbstractHashMap<K, V> extends AbstractMap<K, V> {
    protected int size=0; // number of entries in the hash map
    protected int capacity; // length of the hash table
    private final int p; // prime number
    private final long scale;
    private final long shift; // shift and scaling factors
    public AbstractHashMap(int capacity, int p) {
        this.capacity = capacity;
        this.p = p;
        Random random = new Random();
        this.scale = random.nextInt(p - 1) + 1;
        this.shift = random.nextInt(p);
        createTable();
    }
    public AbstractHashMap(int capacity) {
        this(capacity, 109345121); // default prime number from the book
    }
    public AbstractHashMap() {
        this(17); // default capacity
    }
    /*public methods*/
    @Override
    public int size() {return this.size;}

    @Override
    public V get(K key) {
        int hValue = hashValue(key);
        return hashTableGet(hValue, key);
    }

    @Override
    public V put(K key, V value) {
        int hValue = hashValue(key);
        V old = hashTablePut(hValue, key, value);
        if (this.size > this.capacity / 2)
            resize(2*this.capacity - 1); // keep the alpha <= 0.5
        return old;
    }

    @Override
    public V remove(K key) {
        int hValue = hashValue(key);
        return hashTableRemove(hValue, key);
    }


    protected int hashValue(K key) {
        // from MAD formula [(a*i + b) mod p] mod N
        int i = key.hashCode();
        return (int) (Math.abs((this.scale * i + this.shift) % this.p) % this.capacity);
    }

    private void resize(int newCapacity) {
        LinkedList<KeyValue<K, V>> list = new LinkedList<>();
        for(KeyValue<K, V> item : items())
            list.addLast(item);
        this.capacity = newCapacity;
        createTable();
        this.size = 0; // re-enter values from scratch
        for (KeyValue<K, V> item : list)
            put(item.getKey(), item.getValue());
    }

    /*protected abstract methods to be implemented by the subclasses*/
    protected abstract void createTable();
    protected abstract V hashTableGet(int hValue, K key);
    protected abstract V hashTablePut(int hValue, K key, V value);
    protected abstract V hashTableRemove(int hValue, K key);
}
