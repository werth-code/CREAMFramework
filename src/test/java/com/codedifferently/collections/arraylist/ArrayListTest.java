package com.codedifferently.collections.arraylist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayListTest {
    ArrayList<String> strList;

    @Before
    public void setUp() throws Exception {
        strList = new ArrayList<>();
    }

    @Test
    public void add() {
        strList.add("Hello");

        String actual = strList.get(0);
        String expected = "Hello";
        System.out.println(actual);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void get() {
        strList.add("Armadillo");

        String actual = strList.get(0);
        String expected = "Armadillo";
        System.out.println(actual);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void size() {
        strList.add("Armadillo");
        strList.add("Chipmunk");

        Integer actual = strList.size();
        Integer expected = 2;
        System.out.println(actual);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void clear() {
        strList.add("Armadillo");
        strList.add("Chipmunk");

        strList.clear();

        Integer actual = strList.size();
        Integer expected = 0;
        System.out.println(actual);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isEmpty() {
        strList.add("Armadillo");
        strList.add("Chipmunk");

        strList.clear();

        Boolean actual = strList.isEmpty();
        Boolean expected = true;
        System.out.println(actual);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeDATA() {
        strList.add("Armadillo");
        strList.add("Chipmunk");

        String actual = strList.remove("Chipmunk");
        String expected = "Chipmunk";
        System.out.println(actual);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeINDEX() {
        strList.add("Armadillo");
        strList.add("Chipmunk");

        strList.remove(0);

        String actual = strList.get(0);
        String expected = "Chipmunk";
        System.out.println(actual);

        Assert.assertEquals(expected, actual);
    }
}