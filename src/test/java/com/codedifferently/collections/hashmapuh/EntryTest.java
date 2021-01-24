package com.codedifferently.collections.hashmapuh;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EntryTest<K, V> {

    HashMapUh<Integer, String> map = new HashMapUh<>(32);

    @Before
    public void setUp() {
    }

    //todo create tests
    @Test
    public void testPut( ) {
        String expected = "textValue";

        map.put(1, expected);
        String actual = map.get(1);

        Assert.assertEquals(expected, actual);
    }
}

