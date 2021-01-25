package com.codedifferently.collections.unsortedmap;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EntryTest<K, V> {

    Integer key = 1;
    String value = "testValue";
    HashMapUh<Integer, String> mapIntStr = new HashMapUh<>(32);

    @Test
    public void testEntryGetKey() {
        Entry newEntry = new Entry(key, value, null);
        String expected = "1";

        String actual = newEntry.getKey().toString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testEntryGetValue() {
        Entry newEntry = new Entry(key, value, null);
        String expected = "testValue";

        String actual = newEntry.getValue().toString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testEntrySetNext() throws Exception {
        String expected = "1";

        Entry entry = new Entry(key, value, null);
        Entry entry1 = new Entry(2, "two", null);
        entry.setNext(entry);
        Entry test = entry.getNext();
        String actual = test.getKey().toString();

        Assert.assertEquals(expected, actual);
    }
}