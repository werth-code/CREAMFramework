package com.codedifferently.collections.hashmapuh;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class HashMapUhTest<K, V> {

        /* the hashmap instantiation is tested
        inherently by instantiation for other tests
        */
    HashMapUh<Integer, String> mapIntStr = new HashMapUh<>(32);
    HashMapUh<String, String> mapStrStr = new HashMapUh<>(32);

    @Test
    public void testGetByKey() throws Exception {
        Integer testKey = 5;
        String expected = "testValue";

        mapIntStr.put(testKey, expected);
        String actual = mapIntStr.get(testKey);

        Assert.assertEquals(expected, actual);
    }

    @Test // test put() with <int, string>
    public void testPut( ) throws Exception {
        String expected = "textValue";

        mapIntStr.put(1, expected);
        String actual = mapIntStr.get(1);

        Assert.assertEquals(expected, actual);
    }

    @Test // test put() with <string, string>
    public void testPut2() throws Exception {
        String testKey = "testKey";
        String expected = "testValue";

        mapStrStr.put(testKey, expected);
        String actual = mapStrStr.get(testKey);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRemoveSuccess() throws Exception {
        String testKey = "testKey";
        String testValue = "testValue";

        mapStrStr.put(testKey, testValue);
        mapStrStr.remove(testKey);

        Assert.assertNull(mapStrStr.get(testKey));
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveException()  throws NulPointerException {

        // remove a key that does not exist
        mapIntStr.remove(1);
    }

    @Test
    public void testArrayist() throws Exception {
        ArrayList<String> items = new ArrayList();
        String expected = "mouse";

        mapStrStr.put("k9", "dog");
        mapStrStr.put("feline", "cat");
        mapStrStr.put("rodent", "mouse");
        items = mapStrStr.asArrayList();
        String actual = items.get(2);

        Assert.assertEquals(expected, actual);
    }
}


