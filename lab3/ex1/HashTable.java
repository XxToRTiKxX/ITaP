import java.util.LinkedList;

public class HashTable<K, V> {
    private static final int DEFAULT_CAPACITY = 16; 
    private LinkedList<Entry<K, V>>[] table;        
    private int size = 0;                           


    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    
    @SuppressWarnings("unchecked")
    public HashTable() {
        table = new LinkedList[DEFAULT_CAPACITY];
    }

   
    private int hash(K key) {
        return Math.abs(key.hashCode() % table.length);
    }

   
    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }

        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                entry.value = value; 
                return;
            }
        }

        table[index].add(new Entry<>(key, value));
        size++;
    }

    
    public V get(K key) {
        int index = hash(key);
        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
        }
        return null; 
    }

    
    public void remove(K key) {
        int index = hash(key);
        if (table[index] != null) {
            var iterator = table[index].iterator();
            while (iterator.hasNext()) {
                Entry<K, V> entry = iterator.next();
                if (entry.key.equals(key)) {
                    iterator.remove();
                    size--;
                    return;
                }
            }
        }
    }

    
    public int size() {
        return size;
    }

    
    public boolean isEmpty() {
        return size == 0;
    }

    
    public static void main(String[] args) {
        HashTable<String, Integer> table = new HashTable<>();
        table.put("one", 1);
        table.put("two", 2);
        table.put("three", 3);

        System.out.println("two = " + table.get("two"));  // 2
        System.out.println("size = " + table.size());      // 3

        table.remove("two");
        System.out.println("after remove size = " + table.size()); // 2
        System.out.println("isEmpty = " + table.isEmpty());        // false
    }
}
