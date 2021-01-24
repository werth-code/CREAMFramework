package com.codedifferently.collections.hashmapuh;

import java.util.ArrayList;
import java.util.logging.Logger;

public class HashMapUh<K, V> {

    static Logger logger = Logger.getGlobal();

    /**
     * field defining default size of map
     */
    private int capacity = 16; //Initial default capacity

    /**
     * field defining an array of map entries
     */
    private Entry<K, V>[] table;

    //todo
    // create a method that takes in a map and capacity
    // to scale the map up in size when outgrown
    /**
     * Use this method to create a new Entry[] table of [int capacity] size
     * @param capacity refers to the size of the table to create
     */
    public HashMapUh(int capacity){
        this.capacity = capacity;
        table = new Entry[capacity];
    }

    /**
     *
     * @param key the map key of key:value
     * @param value the value of key:value
     */
    public void put(K key, V value) throws Exception {
        // todo implement a check of size vs capacity
        // and a method for scaling up when outgrown

        try {
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
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    /**
     *  use this method to get the
     *  value represented by the passed in key
     * @param key the key to search for
     * @return the value associated with the passed key
     */
    public V get(K key){
        V value = null;
        int index = index(key);
        Entry<K, V> entry = table[index];
        while (entry != null){
            if(entry.getKey().equals(key)) {
                value = entry.getValue();
                break;
            }
            entry = entry.getNext();
        }
        return value;
    }

    /**
     * use this method tp
     * remove the entry found at the passed key
     * @param key the key to search for
     */
    public void remove(K key) throws NullPointerException {
        logger.info("trying remove operation " + key);

        try {
            int index = index(key);
            Entry previous = null;
            Entry entry = table[index];
            if (entry.equals(null)) {
                throw new NulPointerException();
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
                    throw new NulPointerException();
                }
                previous = entry;
                //entry = entry.getNext();
            }
        } catch (NulPointerException e) {
            logger.info("entry not found " + key + " " + e.getMessage().toString());
        }
    }

    /**
     * use this method to display all
     * entries in the map
     */
    public ArrayList asArrayList(){
        ArrayList<String> items = new ArrayList();
        for(int i = 0; i < capacity; i++){
            if(table[i] != null){
                Entry<K, V> currentNode = table[i];
                while (currentNode != null){
                    //System.out.println(String.format("Key is %s and value is %s", currentNode.getKey(), currentNode.getValue()));
                    items.add(currentNode.getValue().toString());
                    currentNode = currentNode.getNext();
                }
            }
        }
        return items;
    }

    /**
     * use this method to create an index
     * from the hashcode calculated from
     * passed key
     *
     * @param key the key to hash
     * @return int representation of hashed index
     */
    private int index(K key){
        if(key == null){
            return 0;
        }
        return Math.abs(key.hashCode() % capacity);
    }
}
