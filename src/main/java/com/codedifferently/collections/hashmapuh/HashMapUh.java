package com.codedifferently.collections.hashmapuh;

import com.codedifferently.collections.hashmapuh.exceptions.EmptyArrayListException;
import com.codedifferently.collections.hashmapuh.exceptions.IncorrectTypeException;
import com.codedifferently.collections.hashmapuh.exceptions.MissingElementException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

/**
 * HashMapUh -
 * create a custom hashmap with two parameters
 * instantiate as one of    :
 * -- HashMapUh(Integer K, String V)     :
 *     or
 * -- HashMapUh(String K, String V)      :
 *     or
 * -- HashMapUh(String K, Integer V)     :
 *     or
 * -- HashMapUh(nteger K, Integer V)     :
 *
 *
 * @param <K> key for key:val pair
 * @param <V> val for key:val pair
 */
public class HashMapUh<K, V> {
    static Logger logger = Logger.getGlobal();
    private int capacity; //Initial default capacity

    private Entry<K, V>[] table;

    /**
     * scaleUp() method used to scale the capacity by
     * double. It takes in a HashMapUh
     *
     * @param map map reference to the map passed in
     * @return map (clone with double capacity)
     */
    protected HashMapUh scaleUp(HashMapUh map) {
        int newCapacity = (int) (map.size() * 2); // establish new capacity
        this.table = Arrays.copyOf(map.table.clone(), newCapacity);
        return map;
    }

    /**
     * Use this method to create a new Entry[] table of [int capacity] size
     *
     * @param capacity refers to the size of the table to create
     */
    public HashMapUh(int capacity) {
        this.capacity = capacity;
        table = new Entry[capacity];
    }

    /**
     * capacity(): method is used to get the
     * default size of the table storing the map
     * Entry object.
     * Use size() to get the current capacity of any table
     * after resizing has taken place
     *
     * @return the default capacity if creating new
     * HashMapUh {}
     *
     */
    public int capacity() {
        return capacity;
    }

    /**
     * size(): method is used to look into the table
     * storing the elements and get the current length
     * **capacity, not object count**
     *
     * @return **capacity, not object count**
     */
    public Long size() {
        Long size = Arrays.stream(this.table).count();
        return size;
    }


    /**
     * use this method to put a key and value
     * into a custom hashmapuh
     * @param key   the key of key:value
     * @param value the value of key:value
     */
    public void put(K key, V value) throws IncorrectTypeException {
        // todo implement a check of size vs capacity
        // and a method for scaling up when outgrown

            int index = index(key);
            Entry<K, V> newEntry = new Entry<>(key, value, null);

            if (table[index] == null) {
                table[index] = newEntry;
            } else {
                Entry<K, V> previousNode = null;
                Entry<K, V> currentNode = table[index];
                while (currentNode != null) {
                    if (currentNode.getKey().equals(key)) {
                        currentNode.setValue(value);
                        break;
                    }
                    previousNode = currentNode;
                    currentNode = currentNode.getNext();
                }
                if (previousNode != null)
                    previousNode.setNext(newEntry);
            }
        }

    /**
     * use this method to get the
     * value associated with the passed in key
     *
     * @param key the key to search for
     * @return the value associated with the passed key
     */
    public V get(K key) {
        V value = null;
        int index = index(key);
        Entry<K, V> entry = table[index];
        while (entry != null) {
            if (entry.getKey().equals(key)) {
                value = entry.getValue();
                break;
            }
            entry = entry.getNext();
        }
        return value;
    }

    /**
     * use this method to
     * remove the entry associated with the passed key
     *
     * @param key the key to search for
     */
    public void remove(K key) throws MissingElementException, NullPointerException {
        logger.info("trying remove operation " + key);
        int index = index(key);
        Entry previous = null;
        Entry entry = table[index];
        if (entry == null) {
            throw new MissingElementException();
        }
        while (entry != null) {
            if (entry.getKey().equals(key)) {
                if (previous == null) {
                    entry = entry.getNext();
                    table[index] = entry;
                    logger.info("operation successful ");
                } else {
                    previous.setNext(entry.getNext());
                }
            } else {
                throw new MissingElementException();
            }
            previous = entry;
            //entry = entry.getNext();
        }
    }

    /**
     * create ArrayList from values in HashMapUh
     *
     * @return ArrayList created
     */
    public ArrayList getValuesAsArrayList() throws EmptyArrayListException {
        ArrayList<String> items = new ArrayList();
        logger.info("attempting to create ArrayList");

        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                Entry<K, V> currentNode = table[i];
                while (currentNode != null) {
                    items.add(currentNode.getValue().toString());
                    currentNode = currentNode.getNext();
                }
            }
        }
        if (items.size() == 0) {
            logger.info("ArrayList empty. Possibly empty map object");
            throw new EmptyArrayListException();
        } else {
            logger.info("operation successful  - create ArrayList");
            return items;
        }
    }

    /**
     * use this method to create an index
     * from the hashcode calculated from
     * passed key
     *
     * @param key the key to hash
     * @return int representation of hashed index
     */
    private int index(K key) {
        if (key == null) {
            return 0;
        }
        return Math.abs(key.hashCode() % capacity);
    }
}
