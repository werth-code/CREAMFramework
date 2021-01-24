package com.codedifferently.collections.hashmapuh;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EntryTest<K, V> {

    HashMapUh<Integer, String> mapIntStr = new HashMapUh<>(32);
    HashMapUh<String, String> mapStrStr = new HashMapUh<>(32);


    @Before
    public void setUp() {
    }

    @Test // test put() with <int, string>
    public void testPut( ) {
        String expected = "textValue";

        mapIntStr.put(1, expected);
        String actual = mapIntStr.get(1);

        Assert.assertEquals(expected, actual);
    }

    @Test // test put() with <string, string>
    public void testPut2() {
        String testKey = "testKey";
        String expected = "testValue";

        mapStrStr.put(testKey, expected);
        String actual = mapStrStr.get(testKey);

        Assert.assertEquals(expected, actual);
    }
}

