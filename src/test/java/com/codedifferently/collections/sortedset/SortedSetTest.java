package com.codedifferently.collections.sortedset;

import com.codedifferently.collections.arraylist.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

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
        set.add("a");
        set.add("b");
        Boolean actual = set.contains("b");
        Boolean expected = true;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void get() {
        set.add("a");
        set.add("b");
        String actual = set.get("b");
        String expected = "b";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void remove() {
        set.add("a");
        set.add("b");
        set.remove("b");
        Boolean actual = set.contains("b");
        Boolean expected = false;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void size() {
        set.add("a");
        set.add("b");
        int actual = set.size();
        int expected = 2;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isEmpty() {
        set.add("a");
        set.add("b");
        set.isEmpty();
        int  actual = set.size();
        int  expected = 0;

        Assert.assertEquals(expected, actual);

    }
}