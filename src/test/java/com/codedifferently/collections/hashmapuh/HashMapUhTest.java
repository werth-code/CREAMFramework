package com.codedifferently.collections.hashmapuh;

import org.junit.Assert;
import org.junit.Test;

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
}


