import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Dylan
 * @version 1.0
 * @date 2019/11/24
 */

public class MyHashMap<K, V> implements Map61B<K, V> {

    private static final int INIT_CAPACITY = 16;
    private double loadFactor;
    private int size;                // number of key-value pairs
    private ArrayList<Entry>[] buckets;
    private HashSet<K> keySet;

    private class Entry {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        this(INIT_CAPACITY);
    }

    public MyHashMap(int initialSize) {
        loadFactor = 0.75;
        size = 0;
        keySet = new HashSet<>();
        buckets = new ArrayList[initialSize];
        for (int i = 0; i < initialSize; i++) {
            buckets[i] = new ArrayList<>();
        }
    }

    public MyHashMap(int initialSize, double loadFactor) {
        this.loadFactor = loadFactor;
        size = 0;
        keySet = new HashSet<>();
        buckets = new ArrayList[initialSize];
        for (int i = 0; i < initialSize; i++) {
            buckets[i] = new ArrayList<>();
        }
    }

    @Override
    public boolean containsKey(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Argument to get() is null!");
        }
        return get(key) != null;
    }

    /** return hash value between 0 and initialSize-1 */
    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % buckets.length;
    }

    @Override
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Argument to get() is null!");
        }
        int index = hash(key);
        for (Entry entry : buckets[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private void resize(int newSize) {
        MyHashMap<K, V> temp = new MyHashMap<>(newSize);
        for (int i = 0; i < buckets.length; i++) {
            for (Entry entry : buckets[i]) {
                temp.put(entry.key,entry.value);
            }
        }
        this.buckets = temp.buckets;
        this.size = temp.size;
        this.loadFactor = temp.loadFactor;
    }

    @Override
    public void put(K key, V value) {
        if (key == null) { throw new IllegalArgumentException("Argument to get() is null!");}
        if (value == null) { return;}
        if ((double)size / (double)buckets.length > loadFactor) {
            resize(buckets.length * 2);
        }
        keySet.add(key);
        int index = hash(key);
        if (containsKey(key)) {
            for (Entry entry : buckets[index]) {
                if (entry.key.equals(key)) {
                    entry.value = value;
                    return;
                }
            }
        }
        buckets[index].add(new Entry(key,value));
        size++;
    }

    @Override
    public void clear() {
        size = 0;
        keySet.clear();
        buckets = new ArrayList[INIT_CAPACITY];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
    }

    @Override
    public Set<K> keySet() {
        return keySet;
    }

    @Override
    public Iterator<K> iterator() {
        return keySet.iterator();
    }

    @Override
    public V remove(K key) {
        if (containsKey(key)) {
            return remove(key, get(key));
        }
        return null;
    }

    @Override
    public V remove(K key, V value) {
        if (containsKey(key)) {
            int index = hash(key);
            for (int i = 0; i < buckets[index].size(); i++) {
                if (buckets[index].get(i).key.equals(key)) {
                    if (buckets[index].get(i).value.equals(value)) {
                        size -= 1;
                        keySet.remove(key);
                        buckets[index].remove(i);
                        return value;
                    }
                }
            }
        }
        return null;
    }


}
