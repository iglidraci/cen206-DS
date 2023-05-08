import java.util.ArrayList;
import java.util.Random;

public abstract class AbstractHashMap<K, V> extends AbstractMap<K, V> {
    protected int n = 0; // number of items in the dictionary
    protected int m; // length of the table
    private final long prime;
    private final long a, b;
    public AbstractHashMap(int c, int p) {
        prime = p;
        m = c;
        Random rand = new Random();
        a = rand.nextLong(prime - 1) + 1;
        b = rand.nextLong(prime);
        createTable();
    }
    public AbstractHashMap(int c) {
        this(c, 109345121); // default prime
    }
    public AbstractHashMap() {
        this(17); // default capacity
    }
    // public methods
    @Override
    public int size() {
        return n;
    }

    @Override
    public V get(K key) {
        return slotGet(hashValue(key), key);
    }

    @Override
    public V remove(K key) {
        return slotRemove(hashValue(key), key);
    }

    @Override
    public void put(K key, V value) {
        slotPut(hashValue(key), key, value);
        if(n > m / 2)
            resize(2 * m - 1);
    }

    // private utilities
    private int hashValue(K key) {
        // Universal hashing h(k) = [(a*k + b) mod p] mod m
        return (int) ((Math.abs(key.hashCode()* a + b) % prime) % m);
    }

    private void resize(int newCapacity) {
        ArrayList<Item<K, V>> buffer = new ArrayList<>();
        for(Item<K, V> item : items())
            buffer.add(item);
        m = newCapacity;
        createTable();
        n = 0; // will be recomputed while reinserting entries
        for(Item<K, V> item : buffer)
            put(item.getKey(), item.getValue());
    }

    // protected abstract methods to be implemented by concrete classes
    protected abstract void createTable();
    protected abstract V slotGet(int hash, K key);
    protected abstract void slotPut(int hash, K key, V value);
    protected abstract V slotRemove(int hash, K key);
}
