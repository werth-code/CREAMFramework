package com.codedifferently.collections.hashmapuh;

public class EntryTest<K, V> {
    // None of this is staying.
    // It is a test runner that will be replaced with unit tests

    //todo create tests
    public static void main(String[] args){
        HashMapUh<Integer, String> map = new HashMapUh<>(32);
        System.out.println("Going to add entries in map");
        map.put(null, "Nothing");
        map.put(1, "ETC");
        map.put(2, "John");
        System.out.println("Displaying all the entry in map");
        map.display();
        System.out.println("Removing the entry with key 2");
        map.remove(2);
        map.display();
        System.out.println("Adding duplicate key 1 in map");
        map.put(1, "CSE");
        map.put(2, "John again");
        System.out.println("Displaying all the entry in map again");
        map.display();
        System.out.println("Adding entry with key 17 in map");
        map.put(17, "CS");
        map.display();

        //todo
        /**
         * get, print, remove, print
         * rough logic for testing some things
         */
        var value = map.get(17);
        System.out.printf("Value: %s ", value);
        map.remove(17);
        var valueRecheck = map.get(17);
        System.out.printf("Value: %s ", valueRecheck);
    }
}
