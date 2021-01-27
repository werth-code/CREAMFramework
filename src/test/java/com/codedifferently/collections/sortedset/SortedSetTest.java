package com.codedifferently.collections.sortedset;

import com.codedifferently.collections.arraylist.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SortedSetTest {

    SortedSet<String> set;

    @Before
    public void setUp() {
        set = new SortedSet<>();
    }

    @Test
    public void add() {
        set.add("Hello");

        String actual = set.get("Hello");
        String expected = "Hello";
        System.out.println(actual);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addDuplicate() {
        set.add("Hello");

        Boolean actual = set.add("Hello");
        Boolean expected = false;
        System.out.println(actual);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void contains() {
    }

    @Test
    public void get() {
    }

    @Test
    public void remove() {
    }

    @Test
    public void size() {
    }

    @Test
    public void isEmpty() {
    }
}