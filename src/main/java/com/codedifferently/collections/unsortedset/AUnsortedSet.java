package com.codedifferently.collections.unsortedset;

import com.codedifferently.collections.ASet;

import java.util.*;
import java.util.function.Consumer;
import java.util.logging.Logger;

public class AUnsortedSet<T> implements ASet<T>, Iterable<T> {
    private T[] backingArray;
    private int counter;

    private static final Integer SIZE = 10;
    Logger logger = Logger.getGlobal();

    public AUnsortedSet(){
        backingArray=(T[]) new Object[SIZE];
        counter = 0;
    }

    private class AUnsortedSetIterator<T> implements Iterator<T> { //// TODO: 1/25/21 Two for loop issue.
        private int current;
        T lastElement;

        public  AUnsortedSetIterator() {
            current = 0;
            lastElement = null;
        }

        @Override
        public boolean hasNext() {
            while(current <= counter && backingArray[current] == null){
                current = current++;
            }
            return current <= counter;
        }

        @Override
        public T next() {
            T element = (T) backingArray[current];
            current++;
            lastElement = element;
            return element;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new AUnsortedSetIterator<>();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        for (T t : this) action.accept(t);
    }

    @Override
    public Spliterator<T> spliterator() {
        return Spliterators.spliterator(iterator(), size(), Spliterator.ORDERED);
    }

    @Override
    public Boolean add(T data){
        try {
            if (data == null) throw new NoDataInParameterException();
                for (Object element : backingArray) {
                    if (element == data) return false;
                }

            if (counter == backingArray.length) {
                T[] newArray = Arrays.copyOf(backingArray, backingArray.length * 2);
                newArray[counter] = data;
                counter = counter + 1;
                backingArray = newArray;
                return true;
            } else {
                backingArray[counter] = data;
                counter = counter + 1;
                return true;
            }
        } catch (NoDataInParameterException e) {
            logger.warning("The Data Parameter Must Not Be Empty.");
        }
        return false;
    }

    @Override
    public Boolean contains(T value) {
        return false;
    }

    @Override
    public Object get(T data) {
        return null;
    }

    public boolean equals() {

        String str1 = "Strings are fun";
        String str2 = "Strings are fun";

        return str1.equals(str2);

    }
    public Boolean remove(T data){
        return false;
    }

    public Integer size() {

        //loop keep track of count
        return counter;

    }

    @Override
    public void clear() {

    }

    @Override
    public Boolean isEmpty() {
        return null;
    }

    public Object[] toArray() {
        return new Object[0];
    }

    public T[] getBackingArray() {
        return backingArray;
    }
}


