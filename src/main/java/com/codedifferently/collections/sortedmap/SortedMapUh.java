package com.codedifferently.collections.sortedmap;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.ArrayList;
import java.util.logging.Logger;

public class SortedMapUh<K, V> {
    static Logger logger = Logger.getGlobal();
    private ArrayList<KeyVal> table = new ArrayList<>();

    //// TODO: 1/27/21 Refactor put() to insert new elements according to the chosen sort method 
    /**
     * put() method
     * Add an object containing a key:value pair
     * to the internal ArrayList for storing
     * 
     * @param key key for key:value
     * @param val value for key:value
     */
    public void put(K key, V val) {
        KeyVal<K, V> element = new KeyVal<>();

        if ( table.size() <= 0 ) {
            element = new KeyVal<>();
            element.setKey(key);
            element.setValue(val);
            table.add(element);
        }
        else  {
            try {
                Boolean alreadyExists = containsKey(this.getArrayList(), key.toString());

                if (alreadyExists) throw new KeyAlreadyExistsException();
                else table.add(element);

                } catch (KeyAlreadyExistsException k) {
                    logger.info("Key exists ");

            }
        }
    }

    /**
     * Get the value associated with the passed in key
     *
     * @param key the value of the key to look for
     * @return String value (if found) empty String if not
     */
    public String get(String key) {
        KeyVal<K,V> existingPair;
        String result = "";
        for (KeyVal<K,V> keyVal : table) {
            existingPair = keyVal;
            if (existingPair.getKey() != null) {
                String tempKey = existingPair.getKey().toString();
                if (key.equals(tempKey)) {
                    result = existingPair.getValue().toString();
                }
            }
        }
        return result;
    }

    /**
     * Determine if the value passed in is already present as a key in the list
     *
     * @param tableToCheck the ArrayList passed in to search for the given value
     * @param keyToCheck the value of the key to look for
     * @return Boolean true: if key exists, false: if it does not
     */
    public Boolean containsKey(ArrayList<KeyVal> tableToCheck, String keyToCheck) {
        KeyVal<K, V> existingPair;
        for (int i = 0; i < tableToCheck.size(); i++) {
             existingPair = table.get(i);
                if ( existingPair.getKey() != null ) {
                    String tempKey = existingPair.getKey().toString();
                    if (keyToCheck.equals(tempKey)) {
                        return true;
                    }
                }
            }
            return false;
        }

    /**
     *
      * @return ArrayList<KeyVal> used for manipulation
     */
    public ArrayList<KeyVal> getArrayList() {
        return this.table;
    }
}

