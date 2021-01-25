package com.codedifferently.collections.arraylist;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class AArrayListTest {

    AArrayList aArrayList = new AArrayList();

    ArrayList arrayList = new ArrayList();
    ArrayList arrayList2 = new ArrayList();


    @Test
    public void addToIndexTest() {
        aArrayList.addToIndex(1,"A");
        aArrayList.addToIndex(2,"C");


    }
}
