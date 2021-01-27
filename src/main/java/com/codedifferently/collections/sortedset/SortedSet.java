package com.codedifferently.collections.sortedset;

import com.codedifferently.collections.Set;
import com.codedifferently.collections.sortedset.exceptions.DuplicateDataInSetException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class SortedSet<T> implements Set<T> {
    Logger logger = Logger.getGlobal();

    private ArrayList<T> setItems;
    private Integer count;

    public SortedSet() {
        this.setItems = new ArrayList<>();
        this.count = 0;
    }

    @Override
    public Boolean add(T data) {
        try {
            if (setItems.contains(data)) throw new DuplicateDataInSetException();
            else {
                setItems.add(data);
                ArrayList<T> sorted = (ArrayList<T>) setItems.stream().sorted().collect(Collectors.toList());
                setItems = sorted;
                count++;
            }
        } catch (DuplicateDataInSetException e) {
            logger.warning(e + " Duplicate Data In Set");
        }
        return false;
    }

    @Override
    public T get(T data) {
        return setItems.get(setItems.indexOf(data));
    }

    @Override
    public Boolean contains(T data) {
        return setItems.contains(data);
    }


    @Override
    public Object remove(T data) {
        count--;
        return setItems.remove(data);
    }

    @Override
    public Integer size() {

        return count;
    }

    @Override
    public void clear() {
        setItems = new ArrayList<>();
    }

    @Override
    public Boolean isEmpty() {
        setItems = new ArrayList<>();
        count = 0;
        return true;
    }

    @Override
    public String toString() {
        return "SortedSet{" +
                "setItems=" + setItems +
                ", count=" + count +
                '}';
    }
}
