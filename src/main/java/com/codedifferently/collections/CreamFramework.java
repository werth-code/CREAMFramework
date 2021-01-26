package com.codedifferently.collections;

import com.codedifferently.collections.arraylist.ArrayList;
import com.codedifferently.collections.linkedlist.WerthLinkedList;
import com.codedifferently.collections.sortedset.SortedSet;
import com.codedifferently.collections.unsortedmap.HashMapUh;
import com.codedifferently.collections.unsortedset.UnsortedSet;

public class CreamFramework {
    public static void main(String[] args) throws Exception {

        //// TODO: 1/25/21 LinkedList

        WerthLinkedList<Integer> list = new WerthLinkedList<>();
        WerthLinkedList<String> list2 = new WerthLinkedList<>();
        list2.add("Hi");

        list.add(1);
        list.add(2);

        for(Integer ints : list) {
            System.out.println("*" + ints);
        }

        list.forEach(System.out::println);

        //// TODO: 1/25/21 UnsortedSet

        UnsortedSet<String> unsortedSet = new UnsortedSet<>();
        unsortedSet.add("Hi");
        unsortedSet.add("How Are You Tariq?");
        unsortedSet.add("HOW ARE YOU");

        System.out.println("***** " + unsortedSet.isEmpty() + " " + unsortedSet.size());

        unsortedSet.forEach(System.out::println);

//        for(String ele : unsortedSet) {
//            System.out.println(ele);
//        }

        //// TODO: 1/25/21 ArrayList

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Hello");
        arrayList.add("Goodbye");

        arrayList.forEach(System.out::println);

        //// TODO: 1/25/21 HashMapUh

        HashMapUh<String, Integer> hmap = new HashMapUh<>(10);
        hmap.put("age", 33);

        System.out.println(hmap.get("age"));


    }
}
