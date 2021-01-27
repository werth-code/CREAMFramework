package com.codedifferently.collections.sortedmap;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class SortedMapUhTest {
    SortedMapUh<String, String> sortedMapUh = new SortedMapUh<>();

    @Test
    public void testGetReturnsCorrectValue() {
        sortedMapUh.put("key", "value");
        String expected = "value";

        String actual = sortedMapUh.get("key");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testContainsKeyFalse() {
        sortedMapUh.put("key1", "value");

        ArrayList<KeyVal> testList = sortedMapUh.getArrayList();

        Assert.assertFalse(sortedMapUh.containsKey(testList, "key5"));
    }

    @Test
    public void testContainsKeyTrue() {
        sortedMapUh.put("key1", "value");

        ArrayList<KeyVal> testList = sortedMapUh.getArrayList();

        Assert.assertTrue(sortedMapUh.containsKey(testList, "key1"));
    }

    @Test
    public void testGetArrayListContainsValues() {
        sortedMapUh.put("key1", "value");
        sortedMapUh.put("key2", "value");
        ArrayList<KeyVal> actual = new ArrayList(sortedMapUh.getArrayList());
        int size = actual.size();
        Assert.assertTrue(size > 0);
    }
}

