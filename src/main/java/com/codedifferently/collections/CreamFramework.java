package com.codedifferently.collections;

import com.codedifferently.collections.linkedlist.ALinkedList;
import com.codedifferently.collections.unsortedset.AUnsortedSet;

public class CreamFramework {
    public static void main(String[] args) throws Exception {

        //// TODO: 1/25/21 LinkedList

        ALinkedList<Integer> list = new ALinkedList<>();
        ALinkedList<String> list2 = new ALinkedList<>();

        list2.add("Hi");

        list.add(1);
        list.add(2);
        list.add(3);

        for(Integer ints : list) {
            System.out.println(ints);
        }

        list.forEach(System.out::println);

        //// TODO: 1/25/21 UnsortedSet

        AUnsortedSet<String> unsortedSet = new AUnsortedSet<>();
        unsortedSet.add("Hi");
        unsortedSet.add("How Are You Tariq?");

        unsortedSet.forEach(ele -> System.out.println(ele + "!!!"));
    }
}
