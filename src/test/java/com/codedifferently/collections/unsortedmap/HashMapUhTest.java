package com.codedifferently.collections.unsortedmap;

import com.codedifferently.collections.unsortedmap.exceptions.EmptyArrayListException;
import com.codedifferently.collections.unsortedmap.exceptions.IncorrectTypeException;
import com.codedifferently.collections.unsortedmap.exceptions.MissingElementException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class HashMapUhTest<K, V> {
    /* the hashmap instantiation is tested
    inherently by instantiation for other tests
    */

    HashMapUh<Integer, String> mapIntStr = new HashMapUh<>(32);
    HashMapUh<String, String> mapStrStr = new HashMapUh<>(32);

    @Test
    public void testGetByKey() throws java.lang.Exception {
        Integer testKey = 5;
        String expected = "testValue";

        mapIntStr.put(testKey, expected);
        String actual = mapIntStr.get(testKey);

        Assert.assertEquals(expected, actual);
    }

    @Test // test put() with <int, string>
    public void testPutWithIntStringParams() throws IncorrectTypeException {
        String expected = "textValue";

        mapIntStr.put(1, expected);
        String actual = mapIntStr.get(1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPutWithTwoStringParams() throws java.lang.Exception {
        String testKey = "testKey";
        String expected = "testValue";

        mapStrStr.put(testKey, expected);
        String actual = mapStrStr.get(testKey);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRemoveSuccess() throws java.lang.Exception {
        String testKey = "testKey";
        String testValue = "testValue";

        mapStrStr.put(testKey, testValue);
        mapStrStr.remove(testKey);

        Assert.assertNull(mapStrStr.get(testKey));
    }

    @Test(expected = MissingElementException.class)
    public void testRemoveException2() throws MissingElementException, NullPointerException {
        mapIntStr.remove(1); // remove a key that does not exist
    }

    @Test // test third element after creating map and asking for array
    public void testAsArrayist() throws java.lang.Exception {
        ArrayList<String> items = new ArrayList<>();
        String expected = "mouse";

        mapStrStr.put("k9", "dog");
        mapStrStr.put("feline", "cat");
        mapStrStr.put("rodent", "mouse");
        items = mapStrStr.getValuesAsArrayList();
        String actual = items.get(2);

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = EmptyArrayListException.class)
    public void testAsArrayListEmptyArray() throws EmptyArrayListException {
        HashMapUh<Integer, String> emptyMapIntStr = new HashMapUh<>(32);
        ArrayList<String> items = emptyMapIntStr.getValuesAsArrayList();
    }

    @Test
    public void testGetCapacity() {
        Integer expected = 32;

        Integer actual = mapStrStr.capacity();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSize() {
        Long expected = 32L;

        Long size = mapStrStr.size();

        Assert.assertEquals(expected, size);
    }

    @Test
    public void testScaleUpSizeDoubles() throws EmptyArrayListException, IncorrectTypeException {
        mapStrStr.put("k9", "dog");
        mapStrStr.put("feline", "cat");
        mapStrStr.put("rodent", "mouse");

        Integer size1 = Math.toIntExact(mapStrStr.size());
        HashMapUh<K, V> newMap = mapStrStr.scaleUp(mapStrStr);
        ArrayList test = newMap.getValuesAsArrayList();
        Integer size2 = Math.toIntExact(mapStrStr.size());

        Assert.assertTrue(size1 == size2/2);
    }

    @Test
    public void testScaleUpContentRetained() throws EmptyArrayListException, IncorrectTypeException {
        mapStrStr.put("k9", "dog");
        mapStrStr.put("feline", "cat");
        mapStrStr.put("rodent", "mouse");

        String value1 = mapStrStr.get("k9");
        HashMapUh<K, V> newMap = mapStrStr.scaleUp(mapStrStr);
        ArrayList test = newMap.getValuesAsArrayList();
        String value2 = mapStrStr.get("k9");

        Assert.assertEquals(value1, value2);
    }

    @Test
    public void testClearStringBeforeIsTrue() throws IncorrectTypeException {
        mapStrStr.put("k9", "dog");
        mapStrStr.put("feline", "cat");
        mapStrStr.put("rodent", "mouse");

        String expected = "cat";
        String actual = mapStrStr.get("feline");
        HashMapUh newMap = mapStrStr.clear(mapStrStr);

        Assert.assertTrue(actual == expected);
    }

    @Test
    public void testClearNullAfter() throws IncorrectTypeException {
        mapStrStr.put("k9", "dog");
        mapStrStr.put("feline", "cat");
        mapStrStr.put("rodent", "mouse");

        String test1 = mapStrStr.get("feline");
        HashMapUh newMap = mapStrStr.clear(mapStrStr);
        String test2 = (String) newMap.get("feline");

        Assert.assertNull(test2);
    }

    @Test
    public void testContainsValueTrue() throws EmptyArrayListException, IncorrectTypeException {
        mapStrStr.put("k9", "dog");
        mapStrStr.put("feline", "cat");
        mapStrStr.put("rodent", "mouse");

        Boolean containsValue = mapStrStr.containsValue("cat");

        Assert.assertTrue(containsValue);
    }

    @Test
    public void testContainsValueFalse() throws EmptyArrayListException, IncorrectTypeException {
        mapStrStr.put("k9", "dog");
        //mapStrStr.put("feline", "cat");
        mapStrStr.put("rodent", "mouse");

        Boolean containsValue = mapStrStr.containsValue("cat");

        Assert.assertFalse(containsValue);
    }

    @Test(expected = EmptyArrayListException.class)
    public void testContainsValueEmptyArrayException() throws EmptyArrayListException, IncorrectTypeException{
        HashMapUh<String, String> testMap = new HashMapUh<>(32);
        mapStrStr.containsValue("cat");
    }


    // todo create test to assert
    //  an exception for incorrect type for put()
}
