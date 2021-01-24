package com.codedifferently.collections.hashmapuh;

import org.junit.Assert;
import org.junit.Test;

public class EntryTest<K, V> {

    Integer key = 1;
    String value = "testValue";
    HashMapUh<Integer, String> mapIntStr = new HashMapUh<>(32);

    @Test
    public void testEntryGetKey() {
        Entry newEntry = new Entry(key, value, null);

        String actual = newEntry.getKey().toString();
        String expected = "1";

        Assert.assertEquals(expected, actual);
    }
}

